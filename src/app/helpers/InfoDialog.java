package app.helpers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Erstellt von Julius am 06/05/2017.
 */
public class InfoDialog {

    public static void show(String title, String header, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(message);

        DialogPane alertPane = alert.getDialogPane();

        for (ButtonType type : alertPane.getButtonTypes()) {
            ((Button) alertPane.lookupButton(type)).setOnAction(e -> {
                alertPane.getScene().getWindow().hide();
            });
        }

        alertPane.getScene().setRoot(new Label());

        Scene scene = new Scene(alertPane);
        Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setTitle(title);
        dialog.getIcons().add(new Image(InfoDialog.class.getResourceAsStream("../assets/ANTool_Icon2.png")));

        dialog.showAndWait();
    }

    public static void show(String title, String header, String message) {
        show(title, header, message, AlertType.INFORMATION);
    }

    public static void show(String title, String message, AlertType alertType) {
        show(title, null, message, alertType);
    }

    public static void show(String title, String message) {
        show(title, null, message, AlertType.INFORMATION);
        /*Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle(title);
        stage.getIcons().add(new Image(InfoDialog.class.getResourceAsStream("../assets/ANTool_Icon2.png")));

        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getStylesheets().add(InfoDialog.class.getResource("../assets/global.css").toExternalForm());
        vBox.getStyleClass().add("p-10");
        vBox.setPrefWidth(300);

        vBox.getChildren().add(new Label(message));

        Button okButton = new Button("Ok");
        okButton.setOnAction(event -> stage.close());
        okButton.setMaxWidth(1.7976931348623157E308);
        HBox.setHgrow(okButton,
                Priority.ALWAYS);

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-hbox");

        buttonBox.getChildren()
                .addAll(okButton);

        vBox.getChildren().add(buttonBox);

        stage.setScene(new Scene(vBox));
        stage.show();*/
    }



}
