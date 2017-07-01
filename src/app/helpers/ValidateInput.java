package app.helpers;

import javafx.scene.control.TextInputControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class ValidateInput {
    private static final Map<TextInputControl, Boolean> _textInputControlValidity = new HashMap<>();
    private static final Map<TextInputControl, Boolean> _textInputControlEmptiness = new HashMap<>();

    private final TextInputControl _textInputControl;
    private final Validator _validator;

    public ValidateInput(TextInputControl textInputControl, Validator validator) {
        _textInputControl = textInputControl;
        _validator = validator;
        addValidator();
    }

    //<editor-fold desc="Validierungsmethoden">
    private static Boolean isValidString(String input, String regex) {
        return Pattern.matches(regex,
                input);
    }

    private static Boolean isValidPlainString(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException ignored) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static Boolean isValidDate(String input) {
        return isValidString(input,
                "^(31|30|[012]\\d|\\d)[./](0\\d|1[012]|\\d)[./](\\d{4}|\\d\\d)$");
    }

    private static Boolean isValidPhoneNumber(String input) {
        return isValidString(input,
                "^[0-9\\-\\+]{9,15}$");
    }

    private static Boolean isValidPlz(String input) {
        return isValidString(input, "[0-9]{5}");
    }

    private static Boolean isValidEmailAddress(String input) {
        return isValidString(input,
                "\\A([^\\s@,:\"<>]+)@([^\\s@,:\"<>]+\\.[^\\s@,:\"<>.\\d]{2,}|\\[(\\d{1,3}\\.){3}\\d{1,3}\\])\\z");
    }
    //</editor-fold>

    public static Boolean areAllFieldsValid() {
        Boolean allFieldsValid = Boolean.TRUE;
        for (Entry<TextInputControl, Boolean> entry : _textInputControlValidity.entrySet()) {
            if (entry.getValue() == Boolean.FALSE) allFieldsValid = Boolean.FALSE;
        }
        return allFieldsValid;
    }

    public static Boolean areAllFieldsFilled() {
        Boolean allFieldsFilled = Boolean.TRUE;
        for (Entry<TextInputControl, Boolean> entry : _textInputControlEmptiness.entrySet()) {
            if (entry.getValue() == Boolean.TRUE) allFieldsFilled = Boolean.FALSE;
        }
        return allFieldsFilled;
    }

    private Boolean isFieldEmpty() {
        return _textInputControl.getText().isEmpty();
    }

    private Boolean isFieldValid() {
        String text = _textInputControl.getText();
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
                return Boolean.TRUE;
        }
    }

    private void validateField() {
        setValidity(isFieldValid());
        setEmptiness(isFieldEmpty());

        if (isFieldValid() || isFieldEmpty()) {
            _textInputControl.getStyleClass().removeAll("invalid-input");
        } else {
            if (!_textInputControl.getStyleClass().contains("invalid-input")) {
                _textInputControl.getStyleClass().add("invalid-input");
            }
        }
    }

    private void addValidator() {
        if (_textInputControl != null) {
            _textInputControl.textProperty().addListener((ov, oldValue, newValue) -> validateField());
            validateField();
        }
    }

    private void setValidity(Boolean valid) {
        if (_textInputControlValidity.containsKey(_textInputControl))
            _textInputControlValidity.replace(_textInputControl, valid);
        else _textInputControlValidity.put(_textInputControl, valid);
    }

    private void setEmptiness(Boolean empty) {
        if (_textInputControlEmptiness.containsKey(_textInputControl))
            _textInputControlEmptiness.replace(_textInputControl, empty);
        else _textInputControlEmptiness.put(_textInputControl, empty);
    }

    public enum Validator {
        PHONE_NUMBER, DATE, EMAIL, PLZ, PLAIN_TEXT
    }

}
