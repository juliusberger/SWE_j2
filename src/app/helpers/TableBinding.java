package app.helpers;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Hilfsklasse zur einfachen Tabellenpopulation und Verknüpfung der Tabelleneinträge mit einem Datenmodel.
 *
 * S beschreibt den Typ eines Eintrages in der Tabelle, welcher das Interface {@link I_ModelPropertyAdaptor} implementieren muss. Damit sind die Implementierungen der benötigten Property-Funktionen gesichtert.
 */
public class TableBinding<S extends I_ModelPropertyAdaptor> implements I_TableBinding {
    private final TableView<S> _tableView;
    private final I_ObservableDataAdaptor<S> _dataModel;

    public TableBinding(TableView<S> tableView,
                        I_ObservableDataAdaptor<S> dataModel) {
        _tableView = tableView;
        _dataModel = dataModel;
    }

    /**
     * Binden der typischen Aktionen der Tabelle (CRUD).
     * Binden der Buttons an die jeweiligen Aktionen.
     *
     * @param addButton    Hinzufügen-Button
     * @param editButton   Bearbeiten-Button
     * @param deleteButton Löschen-Button
     */
    @Override
    public void bindAll(Button addButton,
                        Button editButton,
                        Button deleteButton) {
        bindTableToData();
        bindTableAddButton(addButton);
        bindTableEditButton(editButton);
        bindTableDeleteButton(deleteButton);
        observeDisabledButtonState(editButton,
                deleteButton);
    }

    /**
     * Bindet die Tabellenpopulation an das Datenmodel. Dies geschieht (bei JavaFX) über PropertyValueFactories,
     * die mit den String-Propertynames des Models initialisiert werden.
     */
    private void bindTableToData() {
        int index = 0;
        for (String propertyName : _dataModel.getPropertyNames()) {
            _tableView.getColumns()
                    .get(index++)
                    .setCellValueFactory(new PropertyValueFactory<>(propertyName));
        }

        _tableView.setItems(_dataModel.getEntries());
    }

    /**
     * Überwacht das Tableview, ob ein Eintrag ausgewählt ist. Ist dies der Fall, werden alle übergebenen Button aktiviert. Bei keiner Auswahl werden die angegebenen Button deaktiviert.
     *
     * @param disableObservedButtons Buttons, die zu aktivieren/deaktivieren sind (i.d.R. Bearbeiten- und Löschen-Button
     */
    private void observeDisabledButtonState(Button... disableObservedButtons) {
        for (Button b : disableObservedButtons) {
            b.setDisable(true);
        }

        _tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                for (Button b : disableObservedButtons) {
                    b.setDisable(false);
                }
            } else {
                for (Button b : disableObservedButtons) {
                    b.setDisable(true);
                }
            }
        });
    }

    /**
     * Bindet den Löschen-Button an die Aktion des Löschens des aktuell in der Tabelle ausgewählten Eintrags
     *
     * @param deleteButton Löschen-Button, an den die Aktion gebunden werden soll.
     */
    private void bindTableDeleteButton(Button deleteButton) {
        deleteButton.setOnAction(e -> _tableView.getItems()
                .remove(_tableView.getSelectionModel().getSelectedItem()));
    }

    /**
     * Bindet den Hinzufügen-Button. Erstellt beim Klick eine neue {@link Dialog}-Instanz und öffnet einen Dialog mit Feldern mit den Überschriften der Tabellen-Spalten-Überschriften.
     * Beim Klick auf "Speichern" wird durch den Aufruf der Factory-Methode ein neues Element des Typs S erstellt und dem Daten-Model hinzugefügt (und damit auch der Tabelle).
     *
     * @param addButton Hinzufügen-Button, an den die Aktion gebunden werden soll.
     */
    private void bindTableAddButton(Button addButton) {
        addButton.setOnAction(event -> {
            Dialog dialog = new Dialog(getColumnStringPropertyLabels());
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    _dataModel.addEntryWithProperties(dialog.getData());
                }
                dialog.deleteObservers();
            });
            dialog.show();
        });
    }

    /**
     * Bindet den Bearbeiten-Button. Erstellt beim Klick eine neue {@link Dialog}-Instanz und öffnet einen Dialog mit Feldern mit den Überschriften der Tabellen-Spalten-Überschriften.
     * Die Daten werden aus dem jeweiligen Eintrag geladen (Eintrag ist vom Typ {@link I_ModelPropertyAdaptor}) und in die Felder des Dialogs vorgesetzt.
     * Beim Klick auf "Speichern" wird durch den Aufruf der Factory-Methode ein neues Element des Typs S erstellt und dem Daten-Model hinzugefügt (und damit auch der Tabelle).
     *
     * @param editButton Bearbeiten-Button, an den die Aktion gebunden werden soll.
     */
    private void bindTableEditButton(Button editButton) {
        editButton.setOnAction(event -> {
            final S selectedEntry = _tableView.getSelectionModel().getSelectedItem();
            Dialog dialog = new Dialog(getColumnStringPropertyLabels());
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    selectedEntry.setAllProperties(dialog.getData());
                }
                dialog.deleteObservers();
            });
            dialog.setData(selectedEntry.getAllProperties());
            dialog.show();
        });

        _tableView.setRowFactory(tv -> {
            TableRow<S> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    editButton.getOnAction().handle(null);
                }
            });
            return row;
        });
    }

    /**
     * Zieht die Überschriften der Spalten aus der Tabelle.
     * @return Gibt die Strings der Tabellen-Spalten-Überschriften zurück.
     */
    private ArrayList<String> getColumnStringPropertyLabels() {
        ArrayList<String> stringProperties = new ArrayList<>();
        _tableView.getColumns().forEach((TableColumn column) -> stringProperties.add(column.getText()));
        return stringProperties;
    }


}
