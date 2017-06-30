package app.controller;

import app.Constants;
import app.InfoDialog;
import app.helpers.importExport.ProjectExportImportManager;
import app.model.implementation.Project;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 22/04/2017.
 */
public class RootViewController implements Initializable {

    public AnchorPane _anchorPane;

    public MenuItem _newProjectItem;
    public MenuItem _loadProjectItem;
    public MenuItem _saveProjectItem;
    public MenuItem _XmlImportItem;
    public MenuItem _XmlExportItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _newProjectItem.setOnAction(event -> onNewProject());

        _loadProjectItem.setOnAction(event -> ProjectExportImportManager.loadProject());

        _saveProjectItem.setOnAction(event -> ProjectExportImportManager.saveProject());

        _XmlImportItem.setOnAction(event -> ProjectExportImportManager.importXml());

        _XmlExportItem.setOnAction(event -> ProjectExportImportManager.exportXml());
    }

    private void onNewProject() {
        if (InfoDialog.confirm(Constants.CONTEXT_TITLE_COMMON, "Neues Projekt anlegen", "Alle nicht gespeicherten Änderungen gehen verloren. Fortfahren?"))
            Project.getInstance().removeExistingData();
    }


}
