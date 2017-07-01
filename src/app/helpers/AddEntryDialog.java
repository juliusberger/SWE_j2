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
 * Hilfsklasse zur einheitlichen Erstellung von JavaFX-Dialogen. Wird durch {@link TableBinding} genutzt, um Kontextaktionen für Tabelleneinträge durchzuführen.
 * Der Dialog blockiert dabei, bis er durch Speichern oder Schliessen beendet wird. Danach koennen die eingegebenen Daten per {@link #getData()} abgerufen werden.
 */
class AddEntryDialog extends Observable {
    private final Stage _stage;
    private final TextField _textField = new TextField();
    private final List<TextArea> _textAreas = new ArrayList<>();
    private boolean _saveClicked = false;

    /**
     * Initialisiert das Grundgerüst des Dialogs.
     *
     * @param stringProperties Strings für die jeweiligen Überschriften der Textfelder. Das erste Feld ist ein einzeiliges Textfeld, die anderen mehrzeilige Textareas.
     */
    AddEntryDialog(ArrayList<String> stringProperties) {
        _stage = new Stage();

        final Label textFieldLabel = new Label(stringProperties.get(0));
        textFieldLabel.getStyleClass().add("h3");

        stringProperties.remove(0);

        final List<Label> textAreaLabels = new ArrayList<>();
        for (String textAreaLabel : stringProperties) {
            Label label = new Label(textAreaLabel);
            label.getStyleClass().add("h3");

            textAreaLabels.add(label);

            TextArea textArea = new TextArea();
            textArea.setPrefHeight(80);
            textArea.setWrapText(true);
            _textAreas.add(textArea);
        }

        try {
            _stage.initModality(Modality.APPLICATION_MODAL);
            _stage.initStyle(StageStyle.DECORATED);
            _stage.setTitle("Eintrag hinzufügen");
            _stage.getIcons().add(new Image(getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

            VBox vBox = new VBox();
            vBox.setSpacing(10.0);
            vBox.getStylesheets().add(getClass().getResource("../assets/global.css").toExternalForm());
            vBox.getStyleClass().add("p-10");
            vBox.setPrefWidth(300);

            {
                vBox.getChildren().add(textFieldLabel);
                vBox.getChildren().add(_textField);

                for (int index = 0; index < _textAreas.size(); index++) {
                    vBox.getChildren().add(textAreaLabels.get(index));
                    vBox.getChildren().add(_textAreas.get(index));
                }

            }

            {
                Button saveButton = new Button("Speichern");
                Button cancelButton = new Button("Abbrechen");
                saveButton.setOnAction(event -> save());
                cancelButton.setOnAction(event -> close());
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


            _stage.setScene(new Scene(vBox));
        } catch (Exception e) {
            System.out.println("Error while creating the AddEntryDialog.");
        }
    }

    /**
     * Baut den AddEntryDialog auf und zeigt ihn als Overlay über der App.
     */
    void show() {
        _stage.showAndWait();
    }

    /**
     * Setzt das save-Flag auf true und schließt den AddEntryDialog.
     */
    private void save() {
        _saveClicked = true;
        close();
    }

    /**
     * Schließt den AddEntryDialog und benachrichtigt Observer.
     */
    private void close() {
        _stage.close();
        setChanged();
        notifyObservers();
    }

    /**
     * @return boolean, ob beim Schließen des Dialogs "Speichern" gedrückt wurde
     */
    boolean isSaveClicked() {
        return _saveClicked;
    }

//    public String getData(int i) {
//        if (i == 0) {
//            return _textField.getText();
//        } else {
//            return _textAreas.get(i - 1).getText();
//        }
//    }

    /**
     * @return Alle in Textfelder eingegebenen Daten als ArrayList
     */
    ArrayList<String> getData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(_textField.getText());
        for (TextArea textArea : _textAreas) {
            strings.add(textArea.getText());
        }
        return strings;
    }

//    public void setData(int i,
//                        String text) {
//        if (i == 0) {
//            _textField.setText(text);
//        } else {
//            _textAreas.get(i - 1).setText(text);
//        }
//    }

    /**
     * Setzt alle Textfelder mit den angegebenen Daten
     * @param texts ArrayList an Strings, die der Reihenfolge nach in die Textfelder des Dialogs eingesetzt werden
     */
    void setData(ArrayList<String> texts) {
        _textField.setText(texts.get(0));
        for (int index = 0; index < _textAreas.size(); index++) {
            _textAreas.get(index).setText(texts.get(index + 1));
        }
    }
}
