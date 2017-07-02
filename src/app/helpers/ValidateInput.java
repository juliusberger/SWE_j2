package app.helpers;

import javafx.scene.control.TextInputControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/**
 * Klasse zur Validierung von Textfeldern.
 * Validiert den Text innerhalb eines Textfeldes mit der angegebenen Validierungsmethode.
 * Sollte der Text nicht valide sein, wird das Textfeld rot eingerahmt und mit einem roten Ausrufezeichen versehen.
 * <p>
 * Diese Klasse hält zudem die Information über Validität und Füllnung aller validierten Textfelder. Dies ermöglicht eine einfache Abfrage, ob invalide oder leere Felder vorhanden sind.
 */
public class ValidateInput {
    /* Beinhaltet alle validierten Felder und ihre Validität */
    private static final Map<TextInputControl, Boolean> _textInputControlValidity = new HashMap<>();
    /* Beinhaltet alle validierten Felder und den Status ihrer Füllung */
    private static final Map<TextInputControl, Boolean> _textInputControlEmptiness = new HashMap<>();

    private final TextInputControl _textInputControl;
    private final Validator _validator;

    public ValidateInput(TextInputControl textInputControl, Validator validator) {
        _textInputControl = textInputControl;
        _validator = validator;
        addValidator();
    }

    /**
     * Validiert einen String nach einer RegExp
     *
     * @param input Zu validierender String
     * @param regex RegExp, mit der geprüft werden soll.
     * @return Übereinstimmung mit dem Pattern, oder nicht.
     */
    private static Boolean isValidString(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    //<editor-fold desc="Validierungsmethoden">

    /**
     * Prüft, ob ein String keine Zahl ist.
     *
     * @param input Zu validierender String
     */
    private static Boolean isValidPlainString(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException ignored) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Prüft, ob ein String ein gültiges Datum ist.
     *
     * @param input Zu validierender String
     */
    private static Boolean isValidDate(String input) {
        return isValidString(input, "^(31|30|[012]\\d|\\d)[./](0\\d|1[012]|\\d)[./](\\d{4}|\\d\\d)$");
    }

    /**
     * Prüft, ob ein String eine gültige Telefonnummer ist.
     *
     * @param input Zu validierender String
     */
    private static Boolean isValidPhoneNumber(String input) {
        return isValidString(input, "^[0-9\\-\\+]{9,15}$");
    }

    /**
     * Prüft, ob ein String eine gültige Postleitzahl ist.
     *
     * @param input Zu validierender String
     */
    private static Boolean isValidPlz(String input) {
        return isValidString(input, "[0-9]{5}");
    }

    /**
     * Prüft, ob ein String eine gültige E-Mail-Adresse ist.
     *
     * @param input Zu validierender String
     */
    private static Boolean isValidEmailAddress(String input) {
        return isValidString(
                input,
                "\\A([^\\s@,:\"<>]+)@([^\\s@,:\"<>]+\\.[^\\s@,:\"<>.\\d]{2,}|\\[(\\d{1,3}\\.){3}\\d{1,3}\\])\\z"
        );
    }

    /**
     * Gibt an, ob alle validierten Felder valide sind.
     *
     * @return Validität aller validierten Felder
     */
    public static Boolean areAllFieldsValid() {
        Boolean allFieldsValid = Boolean.TRUE;
        for (Entry<TextInputControl, Boolean> entry : _textInputControlValidity.entrySet()) {
            if (entry.getValue() == Boolean.FALSE) allFieldsValid = Boolean.FALSE;
        }
        return allFieldsValid;
    }
    //</editor-fold>

    /**
     * Gibt an, ob alle validierten Felder gefüllt sind.
     *
     * @return Füllung aller validierten Felder
     */
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

    /**
     * Ordnet dem Textfeld die jeweilige Validierungsmethode zu.
     *
     * @return Traversierte Validität der Validierungsmethode.
     */
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

    /**
     * Validiert ein Feld mit der festgelegten Validierungsmethode.
     * Setzt die Validität und Füllung bei Aufruf in die globale HashMap der validierten Felder.
     * Fügt dem Textfeld die o.g. Styles hinzu, falls das Feld nicht valide ist.
     */
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

    /**
     * Fügt dem festgelegten Textfeld die Validierungsmethode hinzu.
     */
    private void addValidator() {
        if (_textInputControl != null) {
            _textInputControl.textProperty().addListener((ov, oldValue, newValue) -> validateField());
            validateField();
        }
    }

    /**
     * Setzt die Validität des Textfelds in der globalen HashMap.
     */
    private void setValidity(Boolean valid) {
        if (_textInputControlValidity.containsKey(_textInputControl))
            _textInputControlValidity.replace(_textInputControl, valid);
        else _textInputControlValidity.put(_textInputControl, valid);
    }

    /**
     * Setzt die Füllung des Textfelds in der globalen HashMap.
     */
    private void setEmptiness(Boolean empty) {
        if (_textInputControlEmptiness.containsKey(_textInputControl))
            _textInputControlEmptiness.replace(_textInputControl, empty);
        else _textInputControlEmptiness.put(_textInputControl, empty);
    }

    /**
     * Mögliche Validierungen. S.u. für Details.
     */
    public enum Validator {
        PHONE_NUMBER, DATE, EMAIL, PLZ, PLAIN_TEXT
    }

}
