package helpers;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public abstract class TableBinding {
    public static <S> void bindTableToData(TableView<S> tableView,
                                           ObservableList<S> observableList,
                                           String... propertyNames) {
        int index = 0;
        for (String propertyName : propertyNames) {
            tableView.getColumns()
                    .get(index++)
                    .setCellValueFactory(new PropertyValueFactory<>(propertyName));
        }

        tableView.setItems(observableList);
    }

    public static <S> void observeDisabledButtonState(TableView<S> tableView,
                                                      Button... disableObservedButtons) {
        for (Button b : disableObservedButtons) {
            b.setDisable(true);
        }

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
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

    public static <S> void bindTableDeleteButton(TableView<S> tableView,
                                                 Button deleteButton) {
        deleteButton.setOnAction(e -> tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem()));
    }

}
