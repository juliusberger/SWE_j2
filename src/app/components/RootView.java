package app.components;

import app.helpers.XMLExporter;
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

    public AnchorPane anchorPane;

    public MenuItem newProjectItem;
    public MenuItem openProjectItem;
    public MenuItem saveProjectItem;
    public MenuItem XMLImportItem;
    public MenuItem XMLExportItem;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        final FileChooser fileChooser = new FileChooser();

        final FileChooser.ExtensionFilter projectExtensionFilter = new FileChooser.ExtensionFilter("ANTool Projekt",
                "*.project");
        final FileChooser.ExtensionFilter XMLExtensionFilter = new FileChooser.ExtensionFilter("XML-Datei",
                "*.xml");

        this.newProjectItem.setOnAction(event -> this.onNewProject());

        this.openProjectItem.setOnAction(event -> {
            fileChooser.setTitle("Projekt öffnen");
            fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
            final File file = fileChooser.showOpenDialog(this.anchorPane.getScene().getWindow());
            if (file != null) {
                this.onLoadFile(file);
            }
        });

        this.saveProjectItem.setOnAction(event -> {
            fileChooser.setTitle("Projekt speichern");
            fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
            final File file = fileChooser.showSaveDialog(this.anchorPane.getScene().getWindow());
            if (file != null) {
                this.onSaveFile(file);
            }
        });

        this.XMLImportItem.setOnAction(event -> {
            fileChooser.setTitle("XML importieren");
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            final File file = fileChooser.showOpenDialog(this.anchorPane.getScene().getWindow());
            if (file != null) {
                this.onLoadFile(file);
            }
        });

        this.XMLExportItem.setOnAction(event -> {
            fileChooser.setTitle("XML exportieren");
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            final File file = fileChooser.showSaveDialog(this.anchorPane.getScene().getWindow());
            if (file != null) {
                this.onSaveFile(file);
            }
        });
    }

    private void onNewProject() {
        // handle new project
    }

    private void onLoadFile(File file) {
        //XML.importXML(file.getAbsolutePath());
    }

    private void onSaveFile(File file) {
/*
        XML.exportXML(file.getAbsolutePath());
*/
        XMLExporter exporter = new XMLExporter(file.getAbsolutePath());
        exporter.exportXML();
    }
}
