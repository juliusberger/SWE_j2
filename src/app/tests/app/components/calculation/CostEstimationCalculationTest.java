package app.components.calculation;

import app.model.implementation.ProjectRegistry;
import app.model.interfaces.CostEstimation.I_Classification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testklasse für {@link CostEstimationCalculation}
 */
class CostEstimationCalculationTest {
    private static final String CALCULATE_MEN_MONTH_NAME = "calculateMenMonths";
    private static final String CALCULATE_FUNCTION_TYPES_SUMS_NAME = "calculateFunctionTypesSums";
    private static final String CALCULATE_IMPACT_FACTOR_NAME = "calculateImpactFactor";
    private static final String PERFORM_AUTOMATIC_OPTIMIZATION_NAME = "performAutomaticOptimization";
    private CostEstimationCalculation _costEstimationCalculation = null;
    // Testmethode: calculateMenMonths(double functionPoints)
    private Method _testCalculateMenMonths = null;
    private Class[] parameterTypes_CALCULATE_MEN_MONTH = null;
    private Object[] parameters_CALCULATE_MEN_MONTH = null;
    // Testmethode: calculateFunctionTypesSums()
    private Method _testCalculateFunctionTyesSums = null;
    // Testmethode: calculateImpactFactor()
    private Method _testCalculateImpactFactor = null;
    // Testmethode: performAutomaticOptimization
    private Method _testPerformAutomaticOptimization = null;

    @BeforeEach
    void setUp() throws Exception {
        _costEstimationCalculation = new CostEstimationCalculation();
        _costEstimationCalculation.setInfluenceFactors(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Testmethode: calculateMenMonths(double functionPoints)
        parameterTypes_CALCULATE_MEN_MONTH = new Class[1];
        parameterTypes_CALCULATE_MEN_MONTH[0] = double.class;
        _testCalculateMenMonths = _costEstimationCalculation.getClass()
                                                            .getDeclaredMethod(CALCULATE_MEN_MONTH_NAME,
                                                                               parameterTypes_CALCULATE_MEN_MONTH
                                                            );
        _testCalculateMenMonths.setAccessible(true);
        parameters_CALCULATE_MEN_MONTH = new Object[1];

        // Testmethode: calculateFunctionTypesSums()
        _testCalculateFunctionTyesSums = _costEstimationCalculation.getClass()
                                                                   .getDeclaredMethod(CALCULATE_FUNCTION_TYPES_SUMS_NAME);
        _testCalculateFunctionTyesSums.setAccessible(true);

        // Testmethode: calculateImpactFactor()
        _testCalculateImpactFactor = _costEstimationCalculation.getClass()
                                                               .getDeclaredMethod(CALCULATE_IMPACT_FACTOR_NAME);
        _testCalculateImpactFactor.setAccessible(true);

        // Testmethode: performAutomaticOptimization()
        _testPerformAutomaticOptimization = _costEstimationCalculation.getClass()
                                                                      .getDeclaredMethod(
                                                                              PERFORM_AUTOMATIC_OPTIMIZATION_NAME);
        _testPerformAutomaticOptimization.setAccessible(true);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 4,58
     * Function Points: 45 < 50 (Jones-Schätzung)
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateMenMonths0() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 45;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation,
                                                                parameters_CALCULATE_MEN_MONTH
        );
        assertEquals(4.58, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 15,98
     * Function Points: 50 <= 233,0 <= 2900 (IBM-Korrespondenztabelle)
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateMenMonths1() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 233.0;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation,
                                                                parameters_CALCULATE_MEN_MONTH
        );
        assertEquals(15.98, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 26,24
     * Function Points: 50 <= 378,0 <= 2900 (IBM-Korrespondenztabelle)
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateMenMonths2() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 378.0;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation,
                                                                parameters_CALCULATE_MEN_MONTH
        );
        assertEquals(26.24, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateMenMonths(double)}
     * Erwartetes Ergebnis: 26,39
     * Function Points: 3576,49 > 2900 (Jones-Schätzung)
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateMenMonths3() throws Exception {
        parameters_CALCULATE_MEN_MONTH[0] = 3576.49;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimationCalculation,
                                                                parameters_CALCULATE_MEN_MONTH
        );
        assertEquals(26.39, Math.round(100.0 * result) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateFunctionTypesSums()}
     * Erwartetes Ergebnis: 221
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateFunctionTypesSums() throws Exception {
        I_Classification classification = ProjectRegistry.getInstance().getClassification();
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

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateImpactFactor()}
     * Erwartetes Ergebnis: 1,15
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateImpactFactor0() throws Exception {
        double result = (double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        assertEquals(1.15, result);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#calculateImpactFactor()}
     * Erwartetes Ergebnis: 0,15
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testCalculateImpactFactor1() throws Exception {
        I_CostEstimationCalculation costEstimationCalculation = new CostEstimationCalculation();
        costEstimationCalculation.setInfluenceFactors(1, 0, 2, 0, 3, 0, 4, 0, 5, 0);
        double result = (Double) _testCalculateImpactFactor.invoke(costEstimationCalculation);
        assertEquals(0.15, 1 - result, 0.001);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#performAutomaticOptimization()}
     * Erwartetes Ergebnis: 0,22
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testPerformAutomaticOptimization0() throws Exception {
        _costEstimationCalculation = new CostEstimationCalculation();
        _costEstimationCalculation.setInfluenceFactors(5, 5, 5, 10, 5, 10, 5, 5, 5, 5);
        // erwartetes Zwischenergebnis: 1,3
        double resultBeforeOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        _testPerformAutomaticOptimization.invoke(_costEstimationCalculation);
        // erwartetes Zwischenergebnis: 1,08
        double resultAfterOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        assertEquals(0.22, Math.round((resultBeforeOptimization - resultAfterOptimization) * 100.0) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#performAutomaticOptimization()}
     * Erwartetes Ergebnis: 0,20
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testPerformAutomaticOptimization1() throws Exception {
        _costEstimationCalculation = new CostEstimationCalculation();
        _costEstimationCalculation.setInfluenceFactors(5, 5, 5, 6, 5, 6, 5, 5, 5, 5);
        // erwartetes Zwischenergebnis: 1,22
        double resultBeforeOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        _testPerformAutomaticOptimization.invoke(_costEstimationCalculation);
        // erwartetes Zwischenergebnis: 1,02
        double resultAfterOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        assertEquals(0.20, Math.round((resultBeforeOptimization - resultAfterOptimization) * 100.0) / 100.0);
    }

    /**
     * Testmethode für {@link CostEstimationCalculation#performAutomaticOptimization()}
     * Erwartetes Ergebnis: 0,1
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    void testPerformAutomaticOptimization2() throws Exception {
        _costEstimationCalculation = new CostEstimationCalculation();
        _costEstimationCalculation.setInfluenceFactors(3, 3, 3, 4, 3, 4, 3, 3, 3, 3);
        // erwartetes Zwischenergebnis: 1,02
        double resultBeforeOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        _testPerformAutomaticOptimization.invoke(_costEstimationCalculation);
        // erwartetes Zwischenergebnis: 0,92
        double resultAfterOptimization = (Double) _testCalculateImpactFactor.invoke(_costEstimationCalculation);
        assertEquals(Math.round((resultBeforeOptimization - resultAfterOptimization) * 100.0) / 100.0, 0.1);
    }
}