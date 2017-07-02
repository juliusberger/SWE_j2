package app.helpers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
class AddEntryDialog extends Observable implements I_AddEntryDialog {
    private final Stage _addEntryDialog;
    private final List<TextArea> _inputTextAreas = new ArrayList<>();
    private boolean _saveClicked = false;

    /**
     * Initialisiert das Grundgerüst des Dialogs.
     *
     * @param inputStringProperties Strings, genutzt für die jeweiligen Überschriften der Textfelder.
     */
    AddEntryDialog(Iterable<String> inputStringProperties) {
        _addEntryDialog = new Stage();

        List<Label> inputTextAreaLabels = new ArrayList<>();
        for (String inputStringProperty : inputStringProperties) {
            Label label = new Label(inputStringProperty);
            label.getStyleClass().add("h3");

            inputTextAreaLabels.add(label);

            TextArea inputTextArea = new TextArea();
            inputTextArea.setPrefHeight(40.0);
            inputTextArea.setWrapText(true);
            _inputTextAreas.add(inputTextArea);
        }

        _addEntryDialog.initModality(Modality.APPLICATION_MODAL);
        _addEntryDialog.initStyle(StageStyle.DECORATED);
        _addEntryDialog.setTitle("Eintrag hinzufügen");
        _addEntryDialog.getIcons().add(new Image(getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

        VBox vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.getStylesheets().add(getClass().getResource("../assets/global.css").toExternalForm());
        vBox.getStyleClass().add("p-10");
        vBox.setPrefWidth(400.0);

        for (int index = 0; index < _inputTextAreas.size(); index++) {
            vBox.getChildren().add(inputTextAreaLabels.get(index));
            vBox.getChildren().add(_inputTextAreas.get(index));
        }

        Button saveButton = new Button("Speichern");
        Button cancelButton = new Button("Abbrechen");

        saveButton.setOnAction(event -> save());
        cancelButton.setOnAction(event -> close());

        saveButton.setMaxWidth(1.7976931348623157E308);
        cancelButton.setMaxWidth(1.7976931348623157E308);

        HBox.setHgrow(saveButton, Priority.ALWAYS);
        HBox.setHgrow(cancelButton, Priority.ALWAYS);

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-hbox");

        buttonBox.getChildren().addAll(saveButton, cancelButton);

        vBox.getChildren().add(buttonBox);

        _addEntryDialog.setScene(new Scene(vBox));
    }

    /**
     * Baut den AddEntryDialog auf und zeigt ihn als Overlay über der App.
     */
    @Override
    public void show() {
        _addEntryDialog.showAndWait();
    }

    /**
     * Setzt das save-Flag auf true und schließt den AddEntryDialog. Damit kann die aufrufende Methode weiter verfahren, und die eingegebenen Daten abrufen.
     */
    private void save() {
        _saveClicked = true;
        close();
    }

    /**
     * Schließt den AddEntryDialog und benachrichtigt Observer.
     */
    private void close() {
        _addEntryDialog.close();
        setChanged();
        notifyObservers();
    }

    /**
     * @return boolean, ob beim Schließen des Dialogs "Speichern" gedrückt wurde, und demnach die Daten abgerufen werden koennen, oder ignoriert werden sollen.
     */
    @Override
    public boolean wasSaveClicked() {
        return _saveClicked;
    }


    /**
     * @return Alle in Textfelder eingegebenen Daten als ArrayList
     */
    @Override
    public ArrayList<String> getData() {
        ArrayList<String> strings = new ArrayList<>();
        for (TextArea textArea : _inputTextAreas) {
            strings.add(textArea.getText());
        }
        return strings;
    }

    /**
     * Setzt alle Textfelder mit den angegebenen Daten
     *
     * @param texts ArrayList an Strings, die der Reihenfolge nach in die Textfelder des Dialogs eingesetzt werden
     */
    @Override
    public void setData(List<String> texts) {
        for (int index = 0; index < _inputTextAreas.size(); index++) {
            _inputTextAreas.get(index).setText(texts.get(index));
        }
    }
}
