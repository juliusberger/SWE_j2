package app.helpers;

import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class ValidateInput {
    private static boolean isValidString(String input,
                                         String regex) {
        return Pattern.matches(regex,
                input);
    }

    private static boolean isValidDate(String input) {
        return isValidString(input,
                "^(31|30|[012]\\d|\\d)[./](0\\d|1[012]|\\d)[./](\\d{4}|\\d\\d)$");
    }

    private static boolean isValidPhoneNumber(String input) {
        return isValidString(input,
                "^[0-9\\-\\+]{9,15}$");
    }

    private static boolean isValidEmailAdress(String input) {
        return isValidString(input,
                "\\A([^\\s@,:\"<>]+)@([^\\s@,:\"<>]+\\.[^\\s@,:\"<>.\\d]{2,}|\\[(\\d{1,3}\\.){3}\\d{1,3}\\])\\z");
    }

    private static boolean isFieldEmpty(TextField textField) {
        return textField.getText().isEmpty();
    }

    public static void validateDateField(TextField textField) {
        validateField(textField,
                isValidDate(textField.getText()));
    }

    public static void validateEmailField(TextField textField) {
        validateField(textField,
                isValidEmailAdress(textField.getText()));
    }

    public static void validatePhoneNumberField(TextField textField) {
        validateField(textField,
                isValidPhoneNumber(textField.getText()));
    }

    public static void validatePLZField(TextField textField) {
        validateField(textField,
                isValidString(textField.getText(),
                        "[0-9]{5}"));
    }

    private static void validateField(TextField textField,
                                      boolean isValid) {
        if (isValid || isFieldEmpty(textField)) {
            textField.getStyleClass().removeAll("invalid-input");
        } else {
            if (!textField.getStyleClass().contains("invalid-input")) {
                textField.getStyleClass().add("invalid-input");
            }
        }
    }

}
