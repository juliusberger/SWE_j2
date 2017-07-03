package app.components.importExport;

/**
 * Manager, der die Funktionen des Imports und Exports für Projekt und XML beinhaltet.
 */
public interface I_ProjectExportImportManager {
    boolean loadProject();

    boolean saveProject();

    boolean importXml();

    boolean exportXml();
}
