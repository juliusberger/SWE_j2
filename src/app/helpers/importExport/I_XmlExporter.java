package app.helpers.importExport;

import app.model.interfaces.I_XmlModelEntity;

/**
 * Interface zum XML-Exporter.
 */
interface I_XmlExporter {
    void setFileName(String fileName);

    void setRootModel(I_XmlModelEntity rootModel);

    /**
     * @return Gibt zurück, ob der Export erfolgreich war, oder nicht.
     */
    boolean exportXml();
}
