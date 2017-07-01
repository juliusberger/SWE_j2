package app.components;

import app.Constants;
import app.InfoDialog;
import app.model.implementation.Project;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.Map;

/**
 * Führt die Aufwandsschätzung sowie deren Optimierung durch
 */
public class CostEstimationCalculation implements I_CostEstimationCalculation {
    private static final I_Classification _classification = Project.getInstance().getClassification();
    private final HashMap<String, String> _influenceFactors = new HashMap<>();
    private double _calculatedFunctionPoints;
    private double _calculatedMenMonths;
    private boolean _isOptimized = false;

    /**
     * Befüllt Hashmap mit allen übergebenenen Parameterwerten, die zuvor in den View eingegeben wurden
     * @param influenceFactors Enthält Einflussfaktor-Kategorie sowie zugehörigen Faktor
     * @throws IllegalArgumentException Wird ausgeführt, falls nicht genau zehn Werte übergeben werden
     */
    public CostEstimationCalculation(String... influenceFactors) throws IllegalArgumentException {
        if (influenceFactors.length != 10) throw new IllegalArgumentException("Anzahl der Einflussfaktoren fehlerhaft");
        _influenceFactors.put("1", influenceFactors[0]);
        _influenceFactors.put("2", influenceFactors[1]);
        _influenceFactors.put("3", influenceFactors[2]);
        _influenceFactors.put("4a", influenceFactors[3]);
        _influenceFactors.put("4b", influenceFactors[4]);
        _influenceFactors.put("4c", influenceFactors[5]);
        _influenceFactors.put("4d", influenceFactors[6]);
        _influenceFactors.put("5", influenceFactors[7]);
        _influenceFactors.put("6", influenceFactors[8]);
        _influenceFactors.put("7", influenceFactors[9]);
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
    public HashMap<String, String> getInfluenceFactors() {
        return _influenceFactors;
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
     * @return Berechneter Einflussfaktor
     */
    private double calculateImpactFactor() {
        int _sumInfluencingFactors = 0;

        _sumInfluencingFactors += _influenceFactors.get("1").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("1"));
        _sumInfluencingFactors += _influenceFactors.get("2").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("2"));
        _sumInfluencingFactors += _influenceFactors.get("3").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("3"));
        _sumInfluencingFactors += _influenceFactors.get("4a").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("4a"));
        _sumInfluencingFactors += _influenceFactors.get("4b").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("4b"));
        _sumInfluencingFactors += _influenceFactors.get("4c").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("4c"));
        _sumInfluencingFactors += _influenceFactors.get("4d").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("4d"));
        _sumInfluencingFactors += _influenceFactors.get("5").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("5"));
        _sumInfluencingFactors += _influenceFactors.get("6").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("6"));
        _sumInfluencingFactors += _influenceFactors.get("7").equals("") ? 0 : Integer.parseInt(_influenceFactors.get("7"));

        return ((double) _sumInfluencingFactors / 100) + 0.7;
    }

    /**
     * Berechnet die Summe der Einflussfaktoren nach IBM-Methode (7 Einflussfaktoren)
     * @return Gesamtsumme der eingegebenen Einflussfaktoren
     */
    private int calculateFunctionTypesSums() {
        int _sumEi = 0;
        int _sumEo = 0;
        int _sumEq = 0;
        int _sumIlf = 0;
        int _sumElf = 0;

        // durchläuft jeden Eintrag der klassifizierten Anforderungen und addiert abhängig von jeweiliger
        // Kategorie und Klassifizierung das zugehörige Gewicht
        for (int indexClassificationEntries = 0; indexClassificationEntries < _classification.getEntries().size(); indexClassificationEntries++) {
            I_ClassificationEntry currentClassificationEntry = _classification.getEntries().get(indexClassificationEntries);

            if (currentClassificationEntry.getCategory().equals("Eingabedaten (EI)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEi += 3;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEi += 4;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEi += 6;
                }
            } else if (currentClassificationEntry.getCategory().equals("Ausgabedaten (EO)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEo += 4;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEo += 5;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEo += 7;
                }
            } else if (currentClassificationEntry.getCategory().equals("Abfragen (EQ)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEq += 3;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEq += 4;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEq += 6;
                }
            } else if (currentClassificationEntry.getCategory().equals("Datenbestände (ILF)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumIlf += 7;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumIlf += 10;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumIlf += 15;
                }
            } else if (currentClassificationEntry.getCategory().equals("Referenzdaten (ELF)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumElf += 5;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumElf += 7;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumElf += 10;
                }
            }
        }

        return _sumEi + _sumEo + _sumEq + _sumIlf + _sumElf;
    }

    /**
     * Berechnet anhand der Function Points die benötigten Mannmonate durch lineare Interpolation nach IBM-Tabelle (1984) oder
     * nach Schätzfunktion von Jones
     * @param _functionPoints Die Anzahl der berechneten Function Points
     * @return Die Anzahl der benötigten Mannmonate
     */
    private double calculateMenMonths(double _functionPoints) {
        double menMonths = 0.0;

        // falls FunctionPoints nicht zwischen 50 und 2900 liegen, wird Schätzfunktion von Jones genutzt,
        // andernfalls die IBM-Korrespondeztabelle von 1984

        if (_functionPoints < 50 || _functionPoints > 2900) {
            menMonths = Math.pow(_functionPoints, 0.4);
        } else {
            for (Map.Entry<Integer, Integer> currentCorrelationEntry : Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.entrySet()) {
                // falls Bedingung wahr ist, ist untere Grenze des Intervalls gefunden
                if (currentCorrelationEntry.getKey() < _functionPoints) {
                    // obere und untere Grenze des Function-Points-Intervalls sowie der zugehörigen Mannmonate auslesen
                    double lowerBoundFunctionPoints = currentCorrelationEntry.getKey();
                    double upperBoundFunctionPoints = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.higherKey(currentCorrelationEntry.getKey());
                    double lowerBoundMenMonths = currentCorrelationEntry.getValue();
                    double upperBoundMenMonths = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.get(Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.higherKey(currentCorrelationEntry.getKey()));

                    // lineare Interpolation zwischen den Intervallgrenzen zur Berechnung der Mannmonate
                    menMonths = ((upperBoundMenMonths - lowerBoundMenMonths) / (upperBoundFunctionPoints - lowerBoundFunctionPoints)) * (_functionPoints - lowerBoundFunctionPoints) + lowerBoundMenMonths;
                }
            }
        }

        return menMonths;
    }

    //TODO: Kommentieren!!!
    @Override
    public void performAutomaticOptimization() {
        if (!areInfluenceBoxesValid()) {
            InfoDialog.show("Automatische Optimierung", "Fehler bei der Optimierung", "Für die automatische Optimierung müssen alle Einflussfaktoren gesetzt sein!", Alert.AlertType.ERROR);
        } else {
            if (_isOptimized) {
                InfoDialog.show("Automatische Optimierung", "Optimierung bereits durchgeführt", "Automatische Optimierung der Einflussfaktoren wurde bereits einmal durchgeführt!", Alert.AlertType.ERROR);
            } else {
                if (Integer.parseInt(_influenceFactors.get("1")) > 0 && Integer.parseInt(_influenceFactors.get("1")) < 4)
                    _influenceFactors.replace("1", Integer.toString(Integer.parseInt(_influenceFactors.get("1")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("1")) > 3 && Integer.parseInt(_influenceFactors.get("1")) < 6)
                    _influenceFactors.replace("1", Integer.toString(Integer.parseInt(_influenceFactors.get("1")) - 2));

                if (Integer.parseInt(_influenceFactors.get("2")) > 0 && Integer.parseInt(_influenceFactors.get("2")) < 4)
                    _influenceFactors.replace("2", Integer.toString(Integer.parseInt(_influenceFactors.get("2")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("2")) > 3 && Integer.parseInt(_influenceFactors.get("2")) < 6)
                    _influenceFactors.replace("2", Integer.toString(Integer.parseInt(_influenceFactors.get("2")) - 2));

                if (Integer.parseInt(_influenceFactors.get("3")) > 0 && Integer.parseInt(_influenceFactors.get("3")) < 4)
                    _influenceFactors.replace("3", Integer.toString(Integer.parseInt(_influenceFactors.get("3")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("3")) > 3 && Integer.parseInt(_influenceFactors.get("3")) < 6)
                    _influenceFactors.replace("3", Integer.toString(Integer.parseInt(_influenceFactors.get("3")) - 2));

                if (Integer.parseInt(_influenceFactors.get("4a")) > 0 && Integer.parseInt(_influenceFactors.get("4a")) < 5)
                    _influenceFactors.replace("4a", Integer.toString(Integer.parseInt(_influenceFactors.get("4a")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("4a")) > 4 && Integer.parseInt(_influenceFactors.get("4a")) < 8)
                    _influenceFactors.replace("4a", Integer.toString(Integer.parseInt(_influenceFactors.get("4a")) - 2));
                else if (Integer.parseInt(_influenceFactors.get("4a")) > 7 && Integer.parseInt(_influenceFactors.get("4a")) < 11)
                    _influenceFactors.replace("4a", Integer.toString(Integer.parseInt(_influenceFactors.get("4a")) - 3));

                if (Integer.parseInt(_influenceFactors.get("4b")) > 0 && Integer.parseInt(_influenceFactors.get("4b")) < 4)
                    _influenceFactors.replace("4b", Integer.toString(Integer.parseInt(_influenceFactors.get("4b")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("4b")) > 3 && Integer.parseInt(_influenceFactors.get("4b")) < 6)
                    _influenceFactors.replace("4b", Integer.toString(Integer.parseInt(_influenceFactors.get("4b")) - 2));

                if (Integer.parseInt(_influenceFactors.get("4c")) > 0 && Integer.parseInt(_influenceFactors.get("4c")) < 5)
                    _influenceFactors.replace("4c", Integer.toString(Integer.parseInt(_influenceFactors.get("4c")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("4c")) > 4 && Integer.parseInt(_influenceFactors.get("4c")) < 8)
                    _influenceFactors.replace("4c", Integer.toString(Integer.parseInt(_influenceFactors.get("4c")) - 2));
                else if (Integer.parseInt(_influenceFactors.get("4c")) > 7 && Integer.parseInt(_influenceFactors.get("4c")) < 11)
                    _influenceFactors.replace("4c", Integer.toString(Integer.parseInt(_influenceFactors.get("4c")) - 3));

                if (Integer.parseInt(_influenceFactors.get("4d")) > 0 && Integer.parseInt(_influenceFactors.get("4d")) < 4)
                    _influenceFactors.replace("4d", Integer.toString(Integer.parseInt(_influenceFactors.get("4d")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("4d")) > 3 && Integer.parseInt(_influenceFactors.get("4d")) < 6)
                    _influenceFactors.replace("4d", Integer.toString(Integer.parseInt(_influenceFactors.get("4d")) - 2));

                if (Integer.parseInt(_influenceFactors.get("5")) > 0 && Integer.parseInt(_influenceFactors.get("5")) < 4)
                    _influenceFactors.replace("5", Integer.toString(Integer.parseInt(_influenceFactors.get("5")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("5")) > 3 && Integer.parseInt(_influenceFactors.get("5")) < 6)
                    _influenceFactors.replace("5", Integer.toString(Integer.parseInt(_influenceFactors.get("5")) - 2));

                if (Integer.parseInt(_influenceFactors.get("6")) > 0 && Integer.parseInt(_influenceFactors.get("6")) < 4)
                    _influenceFactors.replace("6", Integer.toString(Integer.parseInt(_influenceFactors.get("6")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("6")) > 3 && Integer.parseInt(_influenceFactors.get("6")) < 6)
                    _influenceFactors.replace("6", Integer.toString(Integer.parseInt(_influenceFactors.get("6")) - 2));

                if (Integer.parseInt(_influenceFactors.get("7")) > 0 && Integer.parseInt(_influenceFactors.get("7")) < 4)
                    _influenceFactors.replace("7", Integer.toString(Integer.parseInt(_influenceFactors.get("7")) - 1));
                else if (Integer.parseInt(_influenceFactors.get("7")) > 3 && Integer.parseInt(_influenceFactors.get("7")) < 6)
                    _influenceFactors.replace("7", Integer.toString(Integer.parseInt(_influenceFactors.get("7")) - 2));

                performCostEstimation();

                _isOptimized = true;

                InfoDialog.show("Automatische Optimierung", "Optimierung erfolgreich durchgeführt", "Automatische Optimierung der Einflussfaktoren erfolgreich durchgeführt!");
            }
        }
    }

    /**
     * Überprüft, ob alle Eingabefelder in Integer konvertiert und somit weiterverarbeitet werden können
     * @return Wahrheitswert, ob Einflussfaktoren-Felder verarbeitet werden können oder nicht
     */
    private boolean areInfluenceBoxesValid() {
        boolean validFields = false;
        try {
            Integer.parseInt(_influenceFactors.get("1"));
            Integer.parseInt(_influenceFactors.get("2"));
            Integer.parseInt(_influenceFactors.get("3"));
            Integer.parseInt(_influenceFactors.get("4a"));
            Integer.parseInt(_influenceFactors.get("4b"));
            Integer.parseInt(_influenceFactors.get("4c"));
            Integer.parseInt(_influenceFactors.get("4d"));
            Integer.parseInt(_influenceFactors.get("5"));
            Integer.parseInt(_influenceFactors.get("6"));
            Integer.parseInt(_influenceFactors.get("7"));

            validFields = true;
        } catch (NumberFormatException ignored) {
        }
        return validFields;
    }
}