package app.components;

import app.model.implementation.CostEstimation.Classification;
import app.model.implementation.Project;
import app.model.interfaces.CostEstimation.I_Classification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse für {@link CostEstimationCalculation}
 */
class CostEstimationCalculationTest {
    private CostEstimationCalculation _costEstimationCalculation;

    // test method: calculateMenMonths(double functionPoints)
    private Method _testCalculateMenMonths;
    private static final String CALCULATE_MEN_MONTH_NAME = "calculateMenMonths";
    private Class[] parameterTypes_CALCULATE_MEN_MONTH;
    private Object[] parameters_CALCULATE_MEN_MONTH;

    // test method: calculateFunctionTypesSums()
    private Method _testCalculateFunctionTyesSums;
    private static String CALCULATE_FUNCTION_TYPES_SUMS_NAME = "calculateFunctionTypesSums";
    private Class[] parameterTypes_CALCULATE_FUNCTION_TYPES_SUMS;
    private Object[] parameters_CALCULATE_FUNCTION_TYPES_SUMS;


    @BeforeEach
    public void setUp() throws Exception {
        _costEstimationCalculation = new CostEstimationCalculation("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        // test method: calculateMenMonths(double functionPoints)
        parameterTypes_CALCULATE_MEN_MONTH = new Class[1];
        parameterTypes_CALCULATE_MEN_MONTH[0] = double.class;
        _testCalculateMenMonths = _costEstimationCalculation.getClass().getDeclaredMethod(CALCULATE_MEN_MONTH_NAME, parameterTypes_CALCULATE_MEN_MONTH);
        _testCalculateMenMonths.setAccessible(true);
        parameters_CALCULATE_MEN_MONTH = new Object[1];

        // test method: calculateFunctionTypesSums(I_Classification classification)
        _testCalculateFunctionTyesSums = _costEstimationCalculation.getClass().getDeclaredMethod(CALCULATE_FUNCTION_TYPES_SUMS_NAME);
        _testCalculateFunctionTyesSums.setAccessible(true);
        parameters_CALCULATE_FUNCTION_TYPES_SUMS = new Object[1];
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 4,58
     * Function Points: 45 < 50 (Jones-Schätzung)
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testCalculateMenMonths0() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 45;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation, parameters_CALCULATE_MEN_MONTH);
        assertEquals(4.58, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 15,98
     * Function Points: 50 <= 233,0 <= 2900 (IBM-Korrespondenztabelle)
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testCalculateMenMonths1() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 233.0;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation, parameters_CALCULATE_MEN_MONTH);
        assertEquals(15.98, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 26,24
     * Function Points: 50 <= 378,0 <= 2900 (IBM-Korrespondenztabelle)
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testCalculateMenMonths2() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 378.0;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation, parameters_CALCULATE_MEN_MONTH);
        assertEquals(26.24, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 26,39
     * Function Points: 3576,49 > 2900 (Jones-Schätzung)
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testCalculateMenMonths3() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 3576.49;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation, parameters_CALCULATE_MEN_MONTH);
        assertEquals(26.39, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateFunctionTypesSums()}
     * Erwartetes Ergebnis: 221
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testCalculateFunctionTypesSums() throws Exception {
        I_Classification classification = Project.getInstance().getClassification();
        // Die ersten drei Einträge sind bei dieser Methode nicht relevant, weshalb hier jeweils "Test" als Platzhalter gewählt wurde
        // Die klassifizierten Anforderungen entsprechen in der Anzahl der von uns im 3. Semester
        // angefertigten Aufwandsschätzung als Teil der Spezifikation
        // Daraus resultierenden die folgenden Klassifizierungen:
        // EI: 22 x einfach, 1 x mittel, 0 x komplex
        // EO: 8 x einfach, 2 x mittel, 0 x komplex
        // EQ: 3 x einfach, 0 x mittel, 0 x komplex
        // ILF: 0 x einfach, 0 x mittel, 6 x komplex
        // ELF: 0 x einfach, 0 x mittel, 1 x komplex
        // erwartetes Ergebnis: 221

        for (int i = 0; i < 22; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Eingabedaten (EI)");
                add("einfach");
            }});
        }
        for (int i = 0; i < 1; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Eingabedaten (EI)");
                add("mittel");
            }});
        }

        for (int i = 0; i < 8; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Ausgabedaten (EO)");
                add("einfach");
            }});
        }
        for (int i = 0; i < 2; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Ausgabedaten (EO)");
                add("mittel");
            }});
        }

        for (int i = 0; i < 3; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Abfragen (EQ)");
                add("einfach");
            }});
        }

        for (int i = 0; i < 6; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Datenbestände (ILF)");
                add("komplex");
            }});
        }

        for (int i = 0; i < 1; i++) {
            classification.addEntryWithProperties(new ArrayList<String>() {{
                add("Test");
                add("Test");
                add("Test");
                add("Referenzdaten (ELF)");
                add("komplex");
            }});
        }

        int result = (Integer) _testCalculateFunctionTyesSums.invoke(_costEstimationCalculation);
        assertEquals(221, result);
    }
}