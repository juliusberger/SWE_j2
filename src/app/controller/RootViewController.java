package app.controller;

import app.Constants;
import app.InfoDialog;
import app.InfoDialog.AlertType;
import app.helpers.importExport.I_ProjectExportImportManager;
import app.helpers.importExport.ProjectExportImportManager;
import app.model.implementation.ProjectRegistry;
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

        I_ProjectExportImportManager projectExportImportManager = new ProjectExportImportManager();
        _loadProjectItem.setOnAction(event -> projectExportImportManager.loadProject());
        _saveProjectItem.setOnAction(event -> projectExportImportManager.saveProject());
        _xmlImportItem.setOnAction(event -> projectExportImportManager.importXml());
        _xmlExportItem.setOnAction(event -> projectExportImportManager.exportXml());

        _antoolCloseItem.setOnAction(event -> _anchorPane.getScene()
                                                         .getWindow()
                                                         .fireEvent(new WindowEvent(_anchorPane.getScene().getWindow(),
                                                                                    WindowEvent.WINDOW_CLOSE_REQUEST
                                                         )));
    }

    private void onNewProject() {
        if (new InfoDialog(Constants.CONTEXT_TITLE_COMMON,
                           "Neues Projekt anlegen",
                           Constants.CONTEXT_MSG_UNSAVED_CHANGES,
                           AlertType.CONFIRMATION
        ).wasYesClicked()) ProjectRegistry.getInstance().removeExistingData();
    }


}
