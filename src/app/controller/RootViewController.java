package app.controller;

import app.Constants;
import app.InfoDialog;
import app.helpers.importExport.ProjectExportImportManager;
import app.model.implementation.Project;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller für den root View (view/rootView.fxml).
 * Enthält alle Komponenten, in Tabs geordnet.
 * Bindet die Komponentenübergreifenden Kontextaktionen:
 * - Neues Projekt - alle bisher vorhandenen Daten werden
 */
public class RootViewController implements Initializable {
    public AnchorPane _anchorPane;

    public MenuItem _newProjectItem;
    public MenuItem _loadProjectItem;
    public MenuItem _saveProjectItem;
    public MenuItem _xmlImportItem;
    public MenuItem _xmlExportItem;

    public MenuItem _antoolCloseItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _newProjectItem.setOnAction(event -> onNewProject());

        _loadProjectItem.setOnAction(event -> ProjectExportImportManager.loadProject());

        _saveProjectItem.setOnAction(event -> ProjectExportImportManager.saveProject());

        _xmlImportItem.setOnAction(event -> ProjectExportImportManager.importXml());

        _xmlExportItem.setOnAction(event -> ProjectExportImportManager.exportXml());

        _antoolCloseItem.setOnAction(event -> _anchorPane.getScene().getWindow().fireEvent(new WindowEvent(_anchorPane.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST)));
    }

    private void onNewProject() {
        if (InfoDialog.confirm(Constants.CONTEXT_TITLE_COMMON, "Neues Projekt anlegen", Constants.CONTEXT_MSG_UNSAVED_CHANGES))
            Project.getInstance().removeExistingData();
    }


}
