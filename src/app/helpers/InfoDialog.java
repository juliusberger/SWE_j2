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

    private Stage stage;

    InfoDialog(String title,
               String message) {
        this.stage = new Stage();

        this.stage.initModality(Modality.APPLICATION_MODAL);
        this.stage.initStyle(StageStyle.UNIFIED);
        this.stage.setTitle(title);
        this.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getStylesheets().add(this.getClass().getResource("../assets/global.css").toExternalForm());
        vBox.getStyleClass().add("p-10");
        vBox.setPrefWidth(300);

        vBox.getChildren().add(new Label(message));

        Button okButton = new Button("Ok");
        okButton.setOnAction(event -> this.dismiss());
        okButton.setMaxWidth(1.7976931348623157E308);
        HBox.setHgrow(okButton,
                Priority.ALWAYS);

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-hbox");

        buttonBox.getChildren()
                .addAll(okButton);

        vBox.getChildren().add(buttonBox);

        this.stage.setScene(new Scene(vBox));
        this.stage.show();
    }


    private void dismiss() {
        this.stage.close();
    }

}
