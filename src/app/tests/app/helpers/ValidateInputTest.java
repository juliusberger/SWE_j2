package app.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testklasse für {@link ValidateInput}
 */
class ValidateInputTest {
    private static final String IS_VALID_PLAIN_STRING_NAME = "isValidPlainString";
    private static final String IS_VALID_DATE_NAME = "isValidDate";
    private static final String IS_VALID_PHONE_NUMBER_NAME = "isValidPhoneNumber";
    private static final String IS_VALID_PLZ_NAME = "isValidPlz";
    private static final String IS_VALID_EMAIL_ADDRESS_NAME = "isValidEmailAddress";
    private ValidateInput _validateInput;

    // Testmethode: isValidPlainString(String input)
    private Method _testIsValidPlainString;
    private Class[] parameterTypes_IS_VALID_PLAIN_STRING;
    private Object[] parameters_IS_VALID_PLAIN_STRING;
    // Testmethode: isValidDate(String input)
    private Method _testIsValidDate;
    private Class[] parameterTypes_IS_VALID_DATE;
    private Object[] parameters_IS_VALID_DATE;
    // Testmethode: isValidPhoneNumber(String input)
    private Method _testIsValidPhoneNumber;
    private Class[] parameterTypes_IS_VALID_PHONE_NUMBER;
    private Object[] parameters_IS_VALID_PHONE_NUMBER;
    // Testmethode: isValidPlz(String input)
    private Method _testIsValidPlz;
    private Class[] parameterTypes_IS_VALID_PLZ;
    private Object[] parameters_IS_VALID_PLZ;
    // Testmethode: isValidEmailAddress(String input)
    private Method _testIsValidEmailAddress;
    private Class[] parameterTypes_IS_VALID_EMAIL_ADDRESS;
    private Object[] parameters_IS_VALID_EMAIL_ADDRESS;

    @BeforeEach
    public void setUp() throws Exception {
        _validateInput = new ValidateInput(null, null);

        // Testmethode: isValidPlainString(String input)
        parameterTypes_IS_VALID_PLAIN_STRING = new Class[1];
        parameterTypes_IS_VALID_PLAIN_STRING[0] = String.class;
        _testIsValidPlainString = _validateInput.getClass()
                                                .getDeclaredMethod(IS_VALID_PLAIN_STRING_NAME,
                                                                   parameterTypes_IS_VALID_PLAIN_STRING
                                                );
        _testIsValidPlainString.setAccessible(true);
        parameters_IS_VALID_PLAIN_STRING = new Object[1];

        // Testmethode: isValidDate(String input)
        parameterTypes_IS_VALID_DATE = new Class[1];
        parameterTypes_IS_VALID_DATE[0] = String.class;
        _testIsValidDate = _validateInput.getClass()
                                         .getDeclaredMethod(IS_VALID_DATE_NAME, parameterTypes_IS_VALID_DATE);
        _testIsValidDate.setAccessible(true);
        parameters_IS_VALID_DATE = new Object[1];

        // Testmethode: isValidPhoneNumber(String input)
        parameterTypes_IS_VALID_PHONE_NUMBER = new Class[1];
        parameterTypes_IS_VALID_PHONE_NUMBER[0] = String.class;
        _testIsValidPhoneNumber = _validateInput.getClass()
                                                .getDeclaredMethod(IS_VALID_PHONE_NUMBER_NAME,
                                                                   parameterTypes_IS_VALID_PHONE_NUMBER
                                                );
        _testIsValidPhoneNumber.setAccessible(true);
        parameters_IS_VALID_PHONE_NUMBER = new Object[1];

        // Testmethode: isValidPlz(String input)
        parameterTypes_IS_VALID_PLZ = new Class[1];
        parameterTypes_IS_VALID_PLZ[0] = String.class;
        _testIsValidPlz = _validateInput.getClass().getDeclaredMethod(IS_VALID_PLZ_NAME, parameterTypes_IS_VALID_PLZ);
        _testIsValidPlz.setAccessible(true);
        parameters_IS_VALID_PLZ = new Object[1];

        // Testmethode: isValidEmailAddress(String input)
        parameterTypes_IS_VALID_EMAIL_ADDRESS = new Class[1];
        parameterTypes_IS_VALID_EMAIL_ADDRESS[0] = String.class;
        _testIsValidEmailAddress = _validateInput.getClass()
                                                 .getDeclaredMethod(IS_VALID_EMAIL_ADDRESS_NAME,
                                                                    parameterTypes_IS_VALID_EMAIL_ADDRESS
                                                 );
        _testIsValidEmailAddress.setAccessible(true);
        parameters_IS_VALID_EMAIL_ADDRESS = new Object[1];
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlainString(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlainString0() throws Exception {
        parameters_IS_VALID_PLAIN_STRING[0] = "123456789";
        boolean result = (boolean) _testIsValidPlainString.invoke(_validateInput, parameters_IS_VALID_PLAIN_STRING);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlainString(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlainString1() throws Exception {
        parameters_IS_VALID_PLAIN_STRING[0] = "test";
        boolean result = (boolean) _testIsValidPlainString.invoke(_validateInput, parameters_IS_VALID_PLAIN_STRING);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlainString(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlainString2() throws Exception {
        parameters_IS_VALID_PLAIN_STRING[0] = "test123";
        boolean result = (boolean) _testIsValidPlainString.invoke(_validateInput, parameters_IS_VALID_PLAIN_STRING);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate0() throws Exception {
        parameters_IS_VALID_DATE[0] = "01/01/1970";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate1() throws Exception {
        parameters_IS_VALID_DATE[0] = "01/01/70";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate2() throws Exception {
        parameters_IS_VALID_DATE[0] = "01.01. 1970";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate3() throws Exception {
        parameters_IS_VALID_DATE[0] = "1/1/70";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate4() throws Exception {
        parameters_IS_VALID_DATE[0] = "1.1.70";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate5() throws Exception {
        parameters_IS_VALID_DATE[0] = "1.1.1970";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidDate(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidDate6() throws Exception {
        parameters_IS_VALID_DATE[0] = "01.01.1970";
        boolean result = (boolean) _testIsValidDate.invoke(_validateInput, parameters_IS_VALID_DATE);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber0() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "+49 123 456789";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber1() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "+491234567891011";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber2() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "+4912345";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber3() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "012345/33";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber4() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "+49123456789";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber5() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "0123456789";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber6() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "+491234567-8910";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPhoneNumber(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPhoneNumber7() throws Exception {
        parameters_IS_VALID_PHONE_NUMBER[0] = "01234567-891011";
        boolean result = (boolean) _testIsValidPhoneNumber.invoke(_validateInput, parameters_IS_VALID_PHONE_NUMBER);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlz(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlz0() throws Exception {
        parameters_IS_VALID_PLZ[0] = "123456";
        boolean result = (boolean) _testIsValidPlz.invoke(_validateInput, parameters_IS_VALID_PLZ);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlz(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlz1() throws Exception {
        parameters_IS_VALID_PLZ[0] = "1234a";
        boolean result = (boolean) _testIsValidPlz.invoke(_validateInput, parameters_IS_VALID_PLZ);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlz(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlz2() throws Exception {
        parameters_IS_VALID_PLZ[0] = "1234";
        boolean result = (boolean) _testIsValidPlz.invoke(_validateInput, parameters_IS_VALID_PLZ);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlz(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlz3() throws Exception {
        parameters_IS_VALID_PLZ[0] = "12345";
        boolean result = (boolean) _testIsValidPlz.invoke(_validateInput, parameters_IS_VALID_PLZ);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidPlz(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidPlz4() throws Exception {
        parameters_IS_VALID_PLZ[0] = "06789";
        boolean result = (boolean) _testIsValidPlz.invoke(_validateInput, parameters_IS_VALID_PLZ);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidEmailAddress(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidEmailAddress0() throws Exception {
        parameters_IS_VALID_EMAIL_ADDRESS[0] = "max.mustermann@mail.gueltig";
        boolean result = (boolean) _testIsValidEmailAddress.invoke(_validateInput, parameters_IS_VALID_EMAIL_ADDRESS);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidEmailAddress(String)}
     * Erwartetes Ergebnis: false
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidEmailAddress1() throws Exception {
        parameters_IS_VALID_EMAIL_ADDRESS[0] = "max.mustermann.de";
        boolean result = (boolean) _testIsValidEmailAddress.invoke(_validateInput, parameters_IS_VALID_EMAIL_ADDRESS);
        assertFalse(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidEmailAddress(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidEmailAddress2() throws Exception {
        parameters_IS_VALID_EMAIL_ADDRESS[0] = "max@mustermann.de";
        boolean result = (boolean) _testIsValidEmailAddress.invoke(_validateInput, parameters_IS_VALID_EMAIL_ADDRESS);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidEmailAddress(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidEmailAddress3() throws Exception {
        parameters_IS_VALID_EMAIL_ADDRESS[0] = "max.mustermann@mail.de";
        boolean result = (boolean) _testIsValidEmailAddress.invoke(_validateInput, parameters_IS_VALID_EMAIL_ADDRESS);
        assertTrue(result);
    }

    /**
     * Testmethode für {@link ValidateInput#isValidEmailAddress(String)}
     * Erwartetes Ergebnis: true
     *
     * @throws Exception Wird geworfen, falls Test nicht ausführbar
     */
    @Test
    public void testIsValidEmailAddress4() throws Exception {
        parameters_IS_VALID_EMAIL_ADDRESS[0] = "max.mustermann@mail.net";
        boolean result = (boolean) _testIsValidEmailAddress.invoke(_validateInput, parameters_IS_VALID_EMAIL_ADDRESS);
        assertTrue(result);
    }
}