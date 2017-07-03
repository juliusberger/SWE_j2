package app.components.importExport;

import app.model.interfaces.I_XmlModelEntity;

/**
 * Interface zum XML-Exporter.
 */
interface I_XmlImporter {
    void setFileName(String fileName);

    void setRootModel(I_XmlModelEntity rootModel);

    /**
     * @return Gibt zurück, ob der Import erfolgreich war, oder nicht.
     */
    boolean importXml();
}
