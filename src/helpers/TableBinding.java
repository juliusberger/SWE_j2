package helpers;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.interfaces.I_ModelPropertyAdaptor;
import models.interfaces.I_ObservableDataAdaptor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class TableBinding<S extends I_ModelPropertyAdaptor> {
    private final TableView<S> tableView;
    private final I_ObservableDataAdaptor<S> dataModel;
    private final ArrayList<String> propertyNames;

    public TableBinding(TableView<S> tableView,
                        I_ObservableDataAdaptor<S> dataModel,
                        String... propertyNames) {
        this.tableView = tableView;
        this.dataModel = dataModel;
        this.propertyNames = new ArrayList<>(Arrays.asList(propertyNames));
    }

    public void bindAll(Button addButton,
                        Button editButton,
                        Button deleteButton) {
        this.bindTableToData();
        this.bindTableAddButton(addButton);
        this.bindTableEditButton(editButton);
        this.bindTableDeleteButton(deleteButton);
        this.observeDisabledButtonState(editButton,
                deleteButton);
    }

    private void bindTableToData() {
        int index = 0;
        for (String propertyName : this.propertyNames) {
            this.tableView.getColumns()
                    .get(index++)
                    .setCellValueFactory(new PropertyValueFactory<>(propertyName));
        }

        this.tableView.setItems(this.dataModel.getEntries());
    }

    private void observeDisabledButtonState(Button... disableObservedButtons) {
        for (Button b : disableObservedButtons) {
            b.setDisable(true);
        }

        this.tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
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

    private void bindTableDeleteButton(Button deleteButton) {
        deleteButton.setOnAction(e -> this.tableView.getItems()
                .remove(this.tableView.getSelectionModel().getSelectedItem()));
    }

    private void bindTableAddButton(Button addButton) {
        addButton.setOnAction(event -> {
            Dialog dialog = new Dialog(this.getColumnStringPropertyLabels());
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    this.dataModel.addEntryWithProperties(dialog.getData());
                }
                dialog.deleteObservers();
            });
            dialog.show();
        });
    }

    private void bindTableEditButton(Button editButton) {
        editButton.setOnAction(event -> {
            final S selectedEntry = this.tableView.getSelectionModel().getSelectedItem();
            Dialog dialog = new Dialog(this.getColumnStringPropertyLabels());
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    selectedEntry.setAllProperties(dialog.getData());
                }
                dialog.deleteObservers();
            });
            dialog.setData(selectedEntry.getAllProperties());
            dialog.show();
        });

        this.tableView.setRowFactory(tv -> {
            TableRow<S> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    editButton.getOnAction().handle(null);
                }
            });
            return row;
        });

    }

    private ArrayList<String> getColumnStringPropertyLabels() {
        ArrayList<String> stringProperties = new ArrayList<>();
        this.tableView.getColumns().forEach((TableColumn column) -> stringProperties.add(column.getText()));
        return stringProperties;
    }


}
