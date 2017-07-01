package app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Klasse zum erstellen einfacher Dialoge. Entweder als Informationen mit verschiedener Dringlichkeit, oder als Bestätigungsdialoge mit Ja/Nein Auswahl.
 */
public enum InfoDialog {
    ;

    /**
     * Erstellt einen Informationsdialog mit angegebener Dringlichkeit.
     * @param title Titel, der in der Fensterleiste angezeigt werden soll.
     * @param header Header kurze Überschrift des Problems
     * @param message Ausführliche Nachricht, die angezeigt werden soll.
     * @param alertType Dringlichkeit des Dialogs.
     */
    public static void show(String title, String header, String message, AlertType alertType) {
        if (alertType == AlertType.CONFIRMATION) return;

        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(message);

        DialogPane alertPane = alert.getDialogPane();

        for (ButtonType type : alertPane.getButtonTypes()) {
            ((Button) alertPane.lookupButton(type)).setOnAction(e -> alertPane.getScene().getWindow().hide());
        }

        alertPane.getScene().setRoot(new Label());

        Scene scene = new Scene(alertPane);
        Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.getIcons().add(new Image(InfoDialog.class.getResourceAsStream("assets/ANTool_Icon2.png")));

        dialog.showAndWait();
    }

    public static void show(String title, String header, String message) {
        show(title, header, message, AlertType.INFORMATION);
    }

    /**
     * Erstellt einen Bestätigungsdialog mit Ja/Nein Auswahl.
     * @param title Titel, der in der Fensterleiste angezeigt werden soll.
     * @param header Header kurze Überschrift des Problems
     * @param message Ausführliche Nachricht, die angezeigt werden soll.
     */
    public static boolean confirm(String title, String header, String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        ButtonType buttonJa = new ButtonType("Ja", ButtonData.OK_DONE);
        ButtonType buttonNein = new ButtonType("Nein", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(buttonJa, buttonNein);

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
        dialog.getIcons().add(new Image(InfoDialog.class.getResourceAsStream("assets/ANTool_Icon2.png")));

        dialog.showAndWait();
        return (result.get() != null) && (result.get().getButtonData() == ButtonData.OK_DONE);
    }

}
