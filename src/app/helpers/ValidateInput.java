package app.helpers;

import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class ValidateInput {
    private static final HashMap<TextField, Boolean> _textFieldValidity = new HashMap<>();
    private static final HashMap<TextField, Boolean> _textFieldEmptiness = new HashMap<>();

    private final TextField _textField;
    private final Validator _validator;

    public ValidateInput(TextField textField, Validator validator) {
        _textField = textField;
        _validator = validator;
        addValidator();
    }

    //<editor-fold desc="Validierungsmethoden">
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
    //</editor-fold>

    public static boolean areAllFieldsValid() {
        boolean allFieldsValid = true;
        for (Map.Entry<TextField, Boolean> entry : _textFieldValidity.entrySet()) {
            if (entry.getValue() == Boolean.FALSE) allFieldsValid = false;
        }
        return allFieldsValid;
    }

    public static boolean areAllFieldsFilled() {
        boolean allFieldsFilled = true;
        for (Map.Entry<TextField, Boolean> entry : _textFieldEmptiness.entrySet()) {
            if (entry.getValue() == Boolean.TRUE) allFieldsFilled = false;
        }
        return allFieldsFilled;
    }

    private boolean isFieldEmpty() {
        return _textField.getText().isEmpty();
    }

    private boolean isFieldValid() {
        String text = _textField.getText();
        switch (_validator) {
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

    private void validateField() {
        if (isFieldValid()) {
            setValidity(Boolean.TRUE);
        } else {
            setValidity(Boolean.FALSE);
        }

        if (isFieldEmpty()) {
            setEmptiness(Boolean.TRUE);
        } else {
            setEmptiness(Boolean.FALSE);
        }

        if (isFieldValid() || isFieldEmpty()) {
            _textField.getStyleClass().removeAll("invalid-input");
        } else {
            if (!_textField.getStyleClass().contains("invalid-input")) {
                _textField.getStyleClass().add("invalid-input");
            }
        }
    }

    private void addValidator() {
        if (_textField != null) {
            _textField.textProperty().addListener((ov, oldValue, newValue) -> validateField());
            validateField();
        }
    }

    private void setValidity(Boolean valid) {
        if (!_textFieldValidity.containsKey(_textField)) _textFieldValidity.put(_textField, valid);
        else _textFieldValidity.replace(_textField, valid);
    }

    private void setEmptiness(Boolean empty) {
        if (!_textFieldEmptiness.containsKey(_textField)) _textFieldEmptiness.put(_textField, empty);
        else _textFieldEmptiness.replace(_textField, empty);
    }

    public enum Validator {
        PHONE_NUMBER, DATE, EMAIL, PLZ, PLAIN_TEXT
    }

}
