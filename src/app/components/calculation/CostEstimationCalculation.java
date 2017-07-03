package app.components.calculation;

import app.Constants;
import app.InfoDialog;
import app.InfoDialog.AlertType;
import app.model.implementation.ProjectRegistry;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;

import java.util.*;
import java.util.Map.Entry;

/**
 * Führt die Aufwandsschätzung sowie deren Optimierung durch. Benutzt wird die Function-Point-Methode.
 */
public class CostEstimationCalculation implements I_CostEstimationCalculation {
    private final I_Classification _classification = ProjectRegistry.getInstance().getClassification();
    private final ArrayList<Integer> _influenceFactors = new ArrayList<>(10);
    private double _calculatedFunctionPoints = 0.0;
    private double _calculatedMenMonths = 0.0;


    public CostEstimationCalculation() {
    }

    @Override
    public double getCalculatedFunctionPoints() {
        return _calculatedFunctionPoints;
    }

    @Override
    public double getCalculatedMenMonths() {
        return _calculatedMenMonths;
    }

    @Override
    public List<Integer> getInfluenceFactors() {
        return Collections.unmodifiableList(_influenceFactors);
    }

    /**
     * Befüllt ArrayList mit allen übergebenenen Parameterwerten, die zuvor in den View eingegeben wurden.
     *
     * @param influenceFactors Enthält Einflussfaktoren, der Reihe nach sowie zugehörigen Faktor
     * @throws IllegalArgumentException Wird ausgeführt, falls nicht genau zehn Werte übergeben werden
     */
    @Override
    public void setInfluenceFactors(Integer... influenceFactors) throws IllegalArgumentException {
        if (influenceFactors.length != 10) throw new IllegalArgumentException("Anzahl der Einflussfaktoren fehlerhaft");
        _influenceFactors.clear();
        _influenceFactors.addAll(Arrays.asList(influenceFactors));
    }

    /**
     * Einstiegspunkt der Aufwandsschätzung-Berechnung. Weist anhand der Berechnungen die Werte für Function Points
     * und Mannmonate mit jeweils zwei Nachkommastellen zu.
     */
    @Override
    public void performCostEstimation() {
        int functionTypesSum = calculateFunctionTypesSums();
        double impactFactor = calculateImpactFactor();
        double functionPoints = functionTypesSum * impactFactor;
        double menMonths = calculateMenMonths(functionPoints);

        _calculatedFunctionPoints = Math.round(functionPoints * 100.0) / 100.0;
        _calculatedMenMonths = Math.round(menMonths * 100.0) / 100.0;
    }

    /**
     * Berechnet die Summe aller eingegebener Einflussfaktoren und erechnet anschließend den daraus resultierenden
     * Multiplikationsfaktor für die Function-Points-Summe
     *
     * @return Berechneter Einflussfaktor
     */
    private double calculateImpactFactor() {
        int sumInfluencingFactors = 0;
        for (Integer influenceFactor : _influenceFactors) {
            sumInfluencingFactors += influenceFactor;
        }

        return (sumInfluencingFactors / 100.0) + 0.7;
    }

    /**
     * Berechnet die Summe der Einflussfaktoren nach IBM-Methode (7 Einflussfaktoren)
     *
     * @return Gesamtsumme der eingegebenen Einflussfaktoren
     */
    private int calculateFunctionTypesSums() {
        // HashMaps ordnen Klassifizierung entsprechendes Gewicht zu
        HashMap<String, Integer> eiWeights = new HashMap<>();
        eiWeights.put("einfach", 3);
        eiWeights.put("mittel", 4);
        eiWeights.put("komplex", 6);

        HashMap<String, Integer> eoWeights = new HashMap<>();
        eoWeights.put("einfach", 4);
        eoWeights.put("mittel", 5);
        eoWeights.put("komplex", 7);

        HashMap<String, Integer> eqWeights = new HashMap<>();
        eqWeights.put("einfach", 3);
        eqWeights.put("mittel", 4);
        eqWeights.put("komplex", 6);

        HashMap<String, Integer> ilfWeights = new HashMap<>();
        ilfWeights.put("einfach", 7);
        ilfWeights.put("mittel", 10);
        ilfWeights.put("komplex", 15);

        HashMap<String, Integer> elfWeights = new HashMap<>();
        elfWeights.put("einfach", 5);
        elfWeights.put("mittel", 7);
        elfWeights.put("komplex", 10);

        int sumEi = 0;
        int sumEo = 0;
        int sumEq = 0;
        int sumIlf = 0;
        int sumElf = 0;

        // durchläuft jeden Eintrag der klassifizierten Anforderungen und addiert abhängig von jeweiliger
        // Kategorie und Klassifizierung das zugehörige Gewicht
        for (int indexClassificationEntries = 0; indexClassificationEntries < _classification.getEntries()
                                                                                             .size(); indexClassificationEntries++) {
            I_ClassificationEntry currentClassificationEntry = _classification.getEntries()
                                                                              .get(indexClassificationEntries);


            if (currentClassificationEntry.getCategory().equals("Eingabedaten (EI)")) {
                sumEi += eiWeights.get(currentClassificationEntry.getClassification());
            } else if (currentClassificationEntry.getCategory().equals("Ausgabedaten (EO)")) {
                sumEo += eoWeights.get(currentClassificationEntry.getClassification());
            } else if (currentClassificationEntry.getCategory().equals("Abfragen (EQ)")) {
                sumEq += eqWeights.get(currentClassificationEntry.getClassification());
            } else if (currentClassificationEntry.getCategory().equals("Datenbestände (ILF)")) {
                sumIlf += ilfWeights.get(currentClassificationEntry.getClassification());
            } else if (currentClassificationEntry.getCategory().equals("Referenzdaten (ELF)")) {
                sumElf += elfWeights.get(currentClassificationEntry.getClassification());
            }
        }

        return sumEi + sumEo + sumEq + sumIlf + sumElf;
    }

    /**
     * Berechnet anhand der Function Points die benötigten Mannmonate durch lineare Interpolation nach IBM-Tabelle (1984) oder
     * nach Schätzfunktion von Jones
     *
     * @param functionPoints Die Anzahl der berechneten Function Points
     * @return Die Anzahl der benötigten Mannmonate
     */
    private double calculateMenMonths(double functionPoints) {
        double menMonths = 0.0;

        // falls FunctionPoints nicht zwischen 50 und 2900 liegen, wird Schätzfunktion von Jones genutzt,
        // andernfalls die IBM-Korrespondeztabelle von 1984

        if ((functionPoints < 50) || (functionPoints > 2900)) {
            menMonths = StrictMath.pow(functionPoints, 0.4);
        } else {
            for (Entry<Integer, Integer> currentCorrelationEntry : Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.descendingMap()
                                                                                                                   .entrySet()) {
                // falls Bedingung wahr ist, ist untere Grenze des Intervalls gefunden
                if (currentCorrelationEntry.getKey() < functionPoints) {
                    // obere und untere Grenze des Function-Points-Intervalls sowie der zugehörigen Mannmonate auslesen
                    double lowerBoundFunctionPoints = currentCorrelationEntry.getKey();
                    double upperBoundFunctionPoints = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.higherKey(
                            currentCorrelationEntry.getKey());
                    double lowerBoundMenMonths = currentCorrelationEntry.getValue();
                    double upperBoundMenMonths = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.get(Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION
                                                                                                              .higherKey(
                                                                                                                      currentCorrelationEntry
                                                                                                                              .getKey()));

                    // lineare Interpolation zwischen den Intervallgrenzen zur Berechnung der Mannmonate
                    menMonths = (((upperBoundMenMonths - lowerBoundMenMonths) / (upperBoundFunctionPoints - lowerBoundFunctionPoints)) * (functionPoints - lowerBoundFunctionPoints)) + lowerBoundMenMonths;
                    break;
                }
            }
        }

        return menMonths;
    }

    /**
     * Führt anhand der Einflussfaktoren eine Selstoptimierung durch, wobei die Werte nach folgendem Algorithmus verringert werden:
     * Bei Einflussfaktoren mit Werten zwischen 0 und 5:
     * Wert zwischen 0 und 3: Verringerung um 1
     * Wert zwischen 4 und 5: Verringerung um 2
     * Bei Einflussfaktoren mit Werten zwischen 0 und 10:
     * Wert zwischen 0 und 4: Verringerung um 1
     * Wert zwischen 5 und 7: Verringerung um 2
     * Wert zwischen 8 und 10: Verringerung um 3
     */
    @Override
    public void performAutomaticOptimization() {
        for (int indexInfluenceFactors = 0; indexInfluenceFactors < _influenceFactors.size(); indexInfluenceFactors++) {
            Integer influenceFactor = _influenceFactors.get(indexInfluenceFactors);
            if (indexInfluenceFactors == 3 || indexInfluenceFactors == 5) {
                if ((influenceFactor > 0) && (influenceFactor < 5)) influenceFactor -= 1;
                else if ((influenceFactor > 4) && (influenceFactor < 8)) influenceFactor -= 2;
                else if ((influenceFactor > 7) && (influenceFactor < 11)) influenceFactor -= 3;
            } else {
                if ((influenceFactor > 0) && (influenceFactor < 4)) influenceFactor -= 1;
                else if ((influenceFactor > 3) && (influenceFactor < 6)) influenceFactor -= 2;
            }
            _influenceFactors.set(indexInfluenceFactors, influenceFactor);
        }

        performCostEstimation();

        new InfoDialog(
                "Automatische Optimierung",
                "Optimierung erfolgreich durchgeführt",
                "Automatische Optimierung der Einflussfaktoren erfolgreich durchgeführt!",
                AlertType.INFORMATION
        );
    }
}