package app.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Michi on 26.06.2017.
 */
class CostEstimationTest {
    private CostEstimation _costEstimation;
    private Method _testCalculateMenMonths;
    private static String METHOD_NAME = "performCostEstimation";
    private Class[] parameterTypes;
    private Object[] parameters;

    @BeforeAll
    public void setUp() throws Exception {
        _costEstimation = new CostEstimation();
        parameterTypes = new  Class[1];
        parameterTypes[0] = java.lang.String.class;
        _testCalculateMenMonths = _costEstimation.getClass().getDeclaredMethod(METHOD_NAME, parameterTypes);
        _testCalculateMenMonths.setAccessible(true);
        parameters = new Object[1];
    }

    @Test
    public void set_testCalculateMenMonths() throws Exception {
        parameters[0] = 233.0;
        double result = (Double) _testCalculateMenMonths.invoke(_costEstimation, parameters);
        assertEquals(result, 15.98);
    }

}