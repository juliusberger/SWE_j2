package app.helpers.importExport;

import app.Constants;
import app.InfoDialog;
import app.InfoDialog.AlertType;
import app.Main;
import app.helpers.ValidateInput;
import app.model.implementation.Project;
import app.model.interfaces.I_Project;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;

/**
 * Implementierung von {@link I_ProjectExportImportManager}
 * Speichert und Lädt Projektdateien (*.project) und XML-Dateien. Beide werden im XML-Format gespeichert.
 */
public final class ProjectExportImportManager implements I_ProjectExportImportManager {
    private final FileChooser fileChooser = new FileChooser();
    private final ExtensionFilter projectExtensionFilter = new ExtensionFilter("ANTool Projekt", "*.project");
    private final ExtensionFilter XMLExtensionFilter = new ExtensionFilter("XML-Datei", "*.xml");

    public ProjectExportImportManager() {
    }

    @Override
    public boolean loadProject() {
        fileChooser.setTitle("Projekt öffnen");
        fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
        File file = fileChooser.showOpenDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onLoadFile(file)) {
                new InfoDialog(
                        "Projekt laden",
                        "Laden erfolgreich!",
                        "Das Projekt wurde erfolgreich geladen.",
                        AlertType.INFORMATION
                );
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveProject() {
        fileChooser.setTitle("Projekt speichern");
        fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
        File file = fileChooser.showSaveDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onSaveFile(file)) {
                new InfoDialog(
                        "Projekt speichern",
                        "Speichern erfolgreich!",
                        "Das Projekt wurde erfolgreich gespeichert.",
                        AlertType.INFORMATION
                );
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean importXml() {
        fileChooser.setTitle("XML importieren");
        fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
        File file = fileChooser.showOpenDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onLoadFile(file)) {
                new InfoDialog(
                        Constants.CONTEXT_TITLE_XML_IMPORT,
                        "Import erfolgreich!",
                        "Die XML-Datei wurde erfolgreich importiert.",
                        AlertType.INFORMATION
                );
                return true;
            }
        }
        return false;
    }

    /**
     * Zeigt den Dateispeicherdialog und führt den XML-Export aus.
     * Zeigt eine Warnmeldung, falls validierte Textfelder nicht ausgefüllt oder fehlerhaft sind.
     * @return Gibt zurück, ob Export erfolgreich war, oder nicht.
     */
    @Override
    public boolean exportXml() {
        boolean continueAnyway = true;
        if (!ValidateInput.areAllFieldsFilled() && !ValidateInput.areAllFieldsValid()) {
            continueAnyway = new InfoDialog(
                    Constants.CONTEXT_TITLE_XML_EXPORT,
                    "Fehlerhafte und leere Textfelder",
                    "Es sind noch unausgefüllte und fehlerhafte Textfelder vorhanden. Trotzdem exportieren?",
                    AlertType.CONFIRMATION
            ).wasYesClicked();
        } else if (!ValidateInput.areAllFieldsValid()) {
            continueAnyway = new InfoDialog(
                    Constants.CONTEXT_TITLE_XML_EXPORT,
                    "Fehlerhafte Textfelder",
                    "Es sind noch fehlerhafte Textfelder vorhanden. Trotzdem exportieren?",
                    AlertType.CONFIRMATION
            ).wasYesClicked();
        } else if (!ValidateInput.areAllFieldsFilled()) {
            continueAnyway = new InfoDialog(
                    Constants.CONTEXT_TITLE_XML_EXPORT,
                    "Fehlerhafte Textfelder",
                    "Es sind noch unausgefüllte Textfelder vorhanden. Trotzdem exportieren?",
                    AlertType.CONFIRMATION
            ).wasYesClicked();
        }
        if (continueAnyway) {
            fileChooser.setTitle(Constants.CONTEXT_TITLE_XML_EXPORT);
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            File file = fileChooser.showSaveDialog(Main.getPrimaryStage().getScene().getWindow());
            if (file != null) {
                if (onSaveFile(file)) {
                    new InfoDialog(
                            Constants.CONTEXT_TITLE_XML_EXPORT,
                            "Export erfolgreich!",
                            "Die XML-Datei wurde erfolgreich exportiert.",
                            AlertType.INFORMATION
                    );
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Holt sich I_Project als rootModel, loescht existierende Daten, und übergibt es an den Importer.
     * @param file File-Element aus dem Dateiauswahldialog.
     * @return Gibt zurück, ob Import erfolgreich war, oder nicht.
     */
    private boolean onLoadFile(File file) {
        I_Project project = Project.getInstance();
        project.removeExistingData();
        I_XmlImporter importer = new XmlImporter();
        importer.setFileName(file.getAbsolutePath());
        importer.setRootModel(project);
        return importer.importXml();
    }


    /**
     * Holt sich I_Project als rootModel und übergibt es an den Exporter.
     * @param file File-Element aus dem Dateispeicherdialog.
     * @return Gibt zurück, ob Export erfolgreich war, oder nicht.
     */
    private boolean onSaveFile(File file) {
        I_Project project = Project.getInstance();
        I_XmlExporter exporter = new XmlExporter();
        exporter.setFileName(file.getAbsolutePath());
        exporter.setRootModel(project);
        return exporter.exportXml();
    }
}
