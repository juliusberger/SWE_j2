package app.components.tableBinding;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_ObservableDataAdaptor;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * Hilfsklasse zur einfachen Tabellenpopulation und Verknüpfung der Tabelleneinträge mit einem Datenmodel.
 * S beschreibt den Typ eines Eintrages in der Tabelle, welcher das Interface {@link I_ModelPropertyAdaptor} implementieren muss. Damit sind die Implementierungen der benötigten Property-Funktionen gesichert.
 */
public interface I_TableBinding<S extends I_ModelPropertyAdaptor> {

    void setTableView(TableView<S> tableView);

    void setDataModel(I_ObservableDataAdaptor<S> dataModel);

    /**
     * Binden der typischen Aktionen der Tabelle (CRUD).
     * Binden der Buttons an die jeweiligen Aktionen.
     *
     * @param addButton    Hinzufügen-Button
     * @param editButton   Bearbeiten-Button
     * @param deleteButton Löschen-Button
     */
    void bindButtonsToTableActions(Button addButton, Button editButton, Button deleteButton);

    /**
     * Bindet die Tabellenpopulation an das Datenmodel.
     */
    void bindTableToData();
}
