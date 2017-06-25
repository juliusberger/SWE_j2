package app.controller;

import app.helpers.I_XmlExporter;
import app.helpers.I_XmlImporter;
import app.helpers.XmlExporter;
import app.helpers.XmlImporter;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 22/04/2017.
 */
public class RootView implements Initializable {

    public AnchorPane _anchorPane;

    public MenuItem _newProjectItem;
    public MenuItem _openProjectItem;
    public MenuItem _saveProjectItem;
    public MenuItem _XmlImportItem;
    public MenuItem _XmlExportItem;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        final FileChooser fileChooser = new FileChooser();

        final FileChooser.ExtensionFilter projectExtensionFilter = new FileChooser.ExtensionFilter("ANTool Projekt",
                "*.project");
        final FileChooser.ExtensionFilter XMLExtensionFilter = new FileChooser.ExtensionFilter("XML-Datei",
                "*.xml");

        _newProjectItem.setOnAction(event -> onNewProject());

        _openProjectItem.setOnAction(event -> {
            fileChooser.setTitle("Projekt öffnen");
            fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
            final File file = fileChooser.showOpenDialog(_anchorPane.getScene().getWindow());
            if (file != null) {
                onLoadFile(file);
            }
        });

        _saveProjectItem.setOnAction(event -> {
            fileChooser.setTitle("Projekt speichern");
            fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
            final File file = fileChooser.showSaveDialog(_anchorPane.getScene().getWindow());
            if (file != null) {
                onSaveFile(file);
            }
        });

        _XmlImportItem.setOnAction(event -> {
            fileChooser.setTitle("XML importieren");
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            final File file = fileChooser.showOpenDialog(_anchorPane.getScene().getWindow());
            if (file != null) {
                onLoadFile(file);
            }
        });

        _XmlExportItem.setOnAction(event -> {
            fileChooser.setTitle("XML exportieren");
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            final File file = fileChooser.showSaveDialog(_anchorPane.getScene().getWindow());
            if (file != null) {
                onSaveFile(file);
            }
        });
    }

    private void onNewProject() {
        // handle new project
    }

    private void onLoadFile(File file) {
        I_XmlImporter importer = new XmlImporter(file.getAbsolutePath());
        importer.importXml();
        //XML.importXML(file.getAbsolutePath());
    }

    private void onSaveFile(File file) {
/*
        XML.exportXml(file.getAbsolutePath());
*/
        I_XmlExporter exporter = new XmlExporter(file.getAbsolutePath());
        exporter.exportXml();
    }
}
