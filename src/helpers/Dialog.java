package helpers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Dialog extends Observable {
    private boolean saveClicked = false;

    private final Stage stage;

    private final Label textFieldLabel;
    private final List<Label> textAreaLabels = new ArrayList<>();

    private final TextField textField = new TextField();
    private final List<TextArea> textAreas = new ArrayList<>();


    public Dialog(String textFieldLabel,
                  String... textAreaLabels) {
        this.stage = new Stage();

        this.textFieldLabel = new Label(textFieldLabel);
        this.textFieldLabel.getStyleClass().add("h3");

        for (String textAreaLabel : textAreaLabels) {
            Label label = new Label(textAreaLabel);
            label.getStyleClass().add("h3");

            this.textAreaLabels.add(label);
            this.textAreas.add(new TextArea());
        }
    }

    public void show() {
        try {
            this.stage.initModality(Modality.APPLICATION_MODAL);
            this.stage.initStyle(StageStyle.UNDECORATED);
            this.stage.setTitle("ABC");


            VBox vBox = new VBox();
            vBox.setSpacing(10.0);
            vBox.getStylesheets().add(this.getClass().getResource("../assets/global.css").toExternalForm());
            vBox.getStyleClass().add("p-10");
            vBox.prefHeight(300);
            vBox.prefWidth(400);


            {
                vBox.getChildren().add(textFieldLabel);
                vBox.getChildren().add(textField);

                for (int index = 0; index < this.textAreas.size(); index++) {
                    vBox.getChildren().add(this.textAreaLabels.get(index));
                    vBox.getChildren().add(this.textAreas.get(index));
                }

            }

            {
                Button saveButton = new Button("Speichern");
                Button cancelButton = new Button("Abbrechen");
                saveButton.setOnAction(event -> this.save());
                cancelButton.setOnAction(event -> this.close());
                saveButton.setMaxWidth(1.7976931348623157E308);
                cancelButton.setMaxWidth(1.7976931348623157E308);
                HBox.setHgrow(saveButton,
                        Priority.ALWAYS);
                HBox.setHgrow(cancelButton,
                        Priority.ALWAYS);

                HBox buttonBox = new HBox();
                buttonBox.getStyleClass().add("button-hbox");

                buttonBox.getChildren()
                        .addAll(saveButton,
                                cancelButton);

                vBox.getChildren().add(buttonBox);
            }


            this.stage.setScene(new Scene(vBox));
            this.stage.showAndWait();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private void save() {
        this.saveClicked = true;
        this.close();
    }

    private void close() {
        this.stage.close();
        setChanged();
        notifyObservers();
    }

    public boolean isSaveClicked() {
        return this.saveClicked;
    }

    public String getData(int i) {
        if (i == 0) {
            return this.textField.getText();
        } else {
            return this.textAreas.get(i - 1).getText();
        }
    }

    public void setData(int i,
                        String text) {
        if (i == 0) {
            this.textField.setText(text);
        } else {
            this.textAreas.get(i - 1).setText(text);
        }
    }

    public void setData(String... texts) {
        textField.setText(texts[0]);
        for (int index = 0; index < this.textAreas.size(); index++) {
            textAreas.get(index).setText(texts[index + 1]);
        }
    }
}
