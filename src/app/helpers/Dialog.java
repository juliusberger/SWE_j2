package app.helpers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
 * Hilfsklasse zur einheitlichen Erstellung von JavaFX-Dialogen. Wird hauptsächlich von {@link TableBinding} genutzt, um Kontextaktionen für Tabelleneinträge durchzuführen.
 */
class Dialog extends Observable {
    private boolean saveClicked = false;

    private final Stage stage;

    private final Label textFieldLabel;
    private final List<Label> textAreaLabels = new ArrayList<>();

    private final TextField textField = new TextField();
    private final List<TextArea> textAreas = new ArrayList<>();

    /**
     * Initialisiert das Grundgerüst des Dialogs.
     *
     * @param stringProperties Strings für die jeweiligen Überschriften der Textfelder. Das erste Feld ist ein einzeiliges Textfeld, die anderen mehrzeilige Textareas
     */
    Dialog(ArrayList<String> stringProperties) {
        this.stage = new Stage();

        this.textFieldLabel = new Label(stringProperties.get(0));
        this.textFieldLabel.getStyleClass().add("h3");

        stringProperties.remove(0);

        for (String textAreaLabel : stringProperties) {
            Label label = new Label(textAreaLabel);
            label.getStyleClass().add("h3");

            this.textAreaLabels.add(label);

            TextArea textArea = new TextArea();
            textArea.setPrefHeight(80);
            textArea.setWrapText(true);
            this.textAreas.add(textArea);
        }

        try {
            this.stage.initModality(Modality.APPLICATION_MODAL);
            this.stage.initStyle(StageStyle.UNIFIED);
            this.stage.setTitle("Eintrag hinzufügen");
            this.stage.getIcons().add(new Image(this.getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

            VBox vBox = new VBox();
            vBox.setSpacing(10.0);
            vBox.getStylesheets().add(this.getClass().getResource("../assets/global.css").toExternalForm());
            vBox.getStyleClass().add("p-10");
            vBox.setPrefWidth(300);

            {
                vBox.getChildren().add(this.textFieldLabel);
                vBox.getChildren().add(this.textField);

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
        } catch (Exception e) {
            System.out.println("Error while creating the Dialog.");
        }
    }

    /**
     * Baut den Dialog auf und zeigt ihn als Overlay über der App.
     */
    void show() {
        this.stage.showAndWait();
    }

    /**
     * Setzt das save-Flag auf true und schließt den Dialog.
     */
    private void save() {
        this.saveClicked = true;
        this.close();
    }

    /**
     * Schließt den Dialog und benachrichtigt Observer.
     */
    private void close() {
        this.stage.close();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * @return boolean, ob beim Schließen des Dialogs "Speichern" gedrückt wurde
     */
    boolean isSaveClicked() {
        return this.saveClicked;
    }

//    public String getData(int i) {
//        if (i == 0) {
//            return this.textField.getText();
//        } else {
//            return this.textAreas.get(i - 1).getText();
//        }
//    }

    /**
     * @return Alle in Textfelder eingegebenen Daten als ArrayList
     */
    ArrayList<String> getData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(this.textField.getText());
        for (TextArea textArea : this.textAreas) {
            strings.add(textArea.getText());
        }
        return strings;
    }

//    public void setData(int i,
//                        String text) {
//        if (i == 0) {
//            this.textField.setText(text);
//        } else {
//            this.textAreas.get(i - 1).setText(text);
//        }
//    }

    /**
     * Setzt alle Textfelder mit den angegebenen Daten
     * @param texts ArrayList an Strings, die der Reihenfolge nach in die Textfelder des Dialogs eingesetzt werden
     */
    void setData(ArrayList<String> texts) {
        this.textField.setText(texts.get(0));
        for (int index = 0; index < this.textAreas.size(); index++) {
            this.textAreas.get(index).setText(texts.get(index + 1));
        }
    }
}
