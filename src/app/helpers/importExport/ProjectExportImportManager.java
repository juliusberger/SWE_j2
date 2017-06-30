package app.helpers.importExport;

import app.Constants;
import app.InfoDialog;
import app.Main;
import app.helpers.ValidateInput;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by eju8fe on 6/30/2017.
 */
public class ProjectExportImportManager {
    private static final FileChooser fileChooser = new FileChooser();
    private static final FileChooser.ExtensionFilter projectExtensionFilter = new FileChooser.ExtensionFilter("ANTool Projekt",
            "*.project");
    private static final FileChooser.ExtensionFilter XMLExtensionFilter = new FileChooser.ExtensionFilter("XML-Datei",
            "*.xml");


    public static boolean loadProject() {
        fileChooser.setTitle("Projekt öffnen");
        fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
        final File file = fileChooser.showOpenDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onLoadFile(file)) {
                InfoDialog.show("Projekt laden", "Laden erfolgreich!", "Das Projekt wurde erfolgreich geladen.");
                return true;
            }
        }
        return false;
    }

    public static boolean saveProject() {
        fileChooser.setTitle("Projekt speichern");
        fileChooser.getExtensionFilters().setAll(projectExtensionFilter);
        final File file = fileChooser.showSaveDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onSaveFile(file)) {
                InfoDialog.show("Projekt speichern", "Speichern erfolgreich!", "Das Projekt wurde erfolgreich gespeichert.");
                return true;
            }
        }
        return false;
    }

    public static boolean importXml() {
        fileChooser.setTitle("XML importieren");
        fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
        final File file = fileChooser.showOpenDialog(Main.getPrimaryStage().getScene().getWindow());
        if (file != null) {
            if (onLoadFile(file)) {
                InfoDialog.show(Constants.CONTEXT_TITLE_XML_IMPORT, "Import erfolgreich!", "Die XML-Datei wurde erfolgreich importiert.");
                return true;
            }
        }
        return false;
    }

    public static boolean exportXml() {
        boolean continueAnyway = true;
        if (!ValidateInput.areAllFieldsFilled() && !ValidateInput.areAllFieldsValid()) {
            continueAnyway = InfoDialog.confirm(Constants.CONTEXT_TITLE_XML_EXPORT, "Fehlerhafte und leere Textfelder", "Es sind noch unausgefüllte und fehlerhafte Textfelder vorhanden. Trotzdem exportieren?");
        } else if (!ValidateInput.areAllFieldsValid()) {
            continueAnyway = InfoDialog.confirm(Constants.CONTEXT_TITLE_XML_EXPORT, "Fehlerhafte Textfelder", "Es sind noch fehlerhafte Textfelder vorhanden. Trotzdem exportieren?");
        } else if (!ValidateInput.areAllFieldsFilled()) {
            continueAnyway = InfoDialog.confirm(Constants.CONTEXT_TITLE_XML_EXPORT, "Fehlerhafte Textfelder", "Es sind noch unausgefüllte Textfelder vorhanden. Trotzdem exportieren?");
        }
        if (continueAnyway) {
            fileChooser.setTitle(Constants.CONTEXT_TITLE_XML_EXPORT);
            fileChooser.getExtensionFilters().setAll(XMLExtensionFilter);
            final File file = fileChooser.showSaveDialog(Main.getPrimaryStage().getScene().getWindow());
            if (file != null) {
                if (onSaveFile(file)) {
                    InfoDialog.show(Constants.CONTEXT_TITLE_XML_EXPORT, "Export erfolgreich!", "Die XML-Datei wurde erfolgreich exportiert.");
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean onLoadFile(File file) {
        I_XmlImporter importer = new XmlImporter(file.getAbsolutePath());
        return importer.importXml();
    }

    private static boolean onSaveFile(File file) {
        I_XmlExporter exporter = new XmlExporter(file.getAbsolutePath());
        return exporter.exportXml();
    }
}
