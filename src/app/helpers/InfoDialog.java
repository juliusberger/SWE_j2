package app.helpers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
class InfoDialog {
    static void show(String title, String message) {
        Stage stage = new Stage();

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
        stage.show();
    }
}
