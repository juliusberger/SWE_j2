package app.helpers;

import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class ValidateInput implements I_ValidateInput {

    private static boolean isValidString(String input, String regex) {
        return Pattern.matches(regex,
                input);
    }

    private static boolean isValidPlainString(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException ignored) {
            return true;
        }
        return false;
    }

    private static boolean isValidDate(String input) {
        return isValidString(input,
                "^(31|30|[012]\\d|\\d)[./](0\\d|1[012]|\\d)[./](\\d{4}|\\d\\d)$");
    }

    private static boolean isValidPhoneNumber(String input) {
        return isValidString(input,
                "^[0-9\\-\\+]{9,15}$");
    }

    private static boolean isValidPlz(String input) {
        return isValidString(input, "[0-9]{5}");
    }

    private static boolean isValidEmailAddress(String input) {
        return isValidString(input,
                "\\A([^\\s@,:\"<>]+)@([^\\s@,:\"<>]+\\.[^\\s@,:\"<>.\\d]{2,}|\\[(\\d{1,3}\\.){3}\\d{1,3}\\])\\z");
    }

    private static boolean isFieldEmpty(TextField textField) {
        return textField.getText().isEmpty();
    }


    private static boolean isValid(String text, Validator validator) {
        switch (validator) {
            case PHONE_NUMBER:
                return isValidPhoneNumber(text);
            case DATE:
                return isValidDate(text);
            case EMAIL:
                return isValidEmailAddress(text);
            case PLZ:
                return isValidPlz(text);
            case PLAIN_TEXT:
                return isValidPlainString(text);
            default:
                return false;
        }
    }


    private static void validateField(TextField textField, Validator validator) {
        if (isValid(textField.getText(), validator) || isFieldEmpty(textField)) {
            textField.getStyleClass().removeAll("invalid-input");
        } else {
            if (!textField.getStyleClass().contains("invalid-input")) {
                textField.getStyleClass().add("invalid-input");
            }
        }
    }

}
