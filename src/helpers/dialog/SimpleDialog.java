package helpers.dialog;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class SimpleDialog implements Initializable {

    public VBox root;

    public Button cancelButton;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        cancelButton.setOnAction(event -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.close();
        });
    }
}
