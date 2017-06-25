package app.helpers;

import javafx.scene.control.TextField;

/**
 * Created by Julius on 26.06.17.
 */
public interface I_ValidateInput {
    static void addValidator(TextField textField, Validator validator) {
        textField.textProperty().addListener((ov, oldValue, newValue) -> ValidateInput.validateField(textField, validator));
    }

    public enum Validator {
        PHONE_NUMBER, DATE, EMAIL, PLZ, PLAIN_TEXT
    }
}
