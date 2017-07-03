package app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * Klasse zum erstellen einfacher Dialoge. Entweder als Informationen mit verschiedener Dringlichkeit, oder als Bestätigungsdialoge mit Ja/Nein Auswahl.
 */
public final class InfoDialog {
    private ButtonData _resultButtonData = null;

    /**
     * Erstellt einen Informationsdialog/Bestätigungsdialog mit angegebener Dringlichkeit, zeigt ihn und blockiert den aufrufenden Thread.
     *
     * @param title     Titel, der in der Fensterleiste angezeigt werden soll.
     * @param header    Header kurze Überschrift des Problems
     * @param message   Ausführliche Nachricht, die angezeigt werden soll.
     * @param alertType Dringlichkeit des Dialogs. Für {@link AlertType#CONFIRMATION} wird ein Bestätigungsdialog mit Ja/Nein Auswahl erstellt.
     */
    public InfoDialog(String title, String header, String message, AlertType alertType) {
        try {
            Alert alert = new Alert(alertType.getAlertType());
            alert.setHeaderText(header);
            alert.setContentText(message);

            if (alertType == AlertType.CONFIRMATION) {
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

                ButtonType buttonJa = new ButtonType("Ja", ButtonData.YES);
                ButtonType buttonNein = new ButtonType("Nein", ButtonData.NO);

                alert.getButtonTypes().clear();
                alert.getButtonTypes().addAll(buttonJa, buttonNein);
            }

            DialogPane alertPane = alert.getDialogPane();

            ObjectProperty<ButtonType> result = new SimpleObjectProperty<>();
            for (ButtonType type : alertPane.getButtonTypes()) {
                ((Button) alertPane.lookupButton(type)).setOnAction(e -> {
                    result.set(type);
                    alertPane.getScene().getWindow().hide();
                });
            }

            alertPane.getScene().setRoot(new Label());

            Scene scene = new Scene(alertPane);
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle(title);
            dialog.getIcons().add(new Image(InfoDialog.class.getResourceAsStream("/assets/ANTool_Icon2.png")));

            dialog.showAndWait();
            _resultButtonData = (result.get() == null) ? null : result.get().getButtonData();
        } catch (ExceptionInInitializerError | NoClassDefFoundError e) {
            Log.getLogger()
               .log(
                       Level.SEVERE,
                       "JavaFX fehler, Dialog konnte nicht erstellt werden. Fehler:" + Arrays.toString(e.getStackTrace())
               );
        }
    }

    public ButtonData getResultButtonData() {
        return _resultButtonData;
    }

    /**
     * @return Gibt zurück, ob beim Beenden des Dialogs auf 'Ja' geklickt wurde.
     */
    public boolean wasYesClicked() {
        return (_resultButtonData != null) && (_resultButtonData == ButtonData.YES);
    }

    /**
     * @return Gibt zurück, ob beim Beenden des Dialogs auf 'Nein' geklickt wurde.
     */
    public boolean wasNoClicked() {
        return (_resultButtonData != null) && (_resultButtonData == ButtonData.NO);
    }

    public enum AlertType {
        INFORMATION(Alert.AlertType.INFORMATION),
        WARNING(Alert.AlertType.WARNING),
        ERROR(Alert.AlertType.ERROR),
        CONFIRMATION(Alert.AlertType.CONFIRMATION);

        private final Alert.AlertType _alertType;

        AlertType(Alert.AlertType alertType) {
            _alertType = alertType;
        }

        public Alert.AlertType getAlertType() {
            return _alertType;
        }
    }

}
