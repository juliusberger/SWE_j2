package app.components.importExport;


import app.Constants;
import app.InfoDialog;
import app.InfoDialog.AlertType;
import app.Log;
import app.model.interfaces.I_XmlModelEntity;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Diese Klasse implementiert die zu {@link I_XmlImporter} gehörige Import-Funktion.
 * Dazu wird die festgelegte Datei, und das root-Model als Einstiegspunkt genutzt.
 * Die benötigten Model-Repräsentationen für den Import/Export sind durch {@link I_XmlModelEntity} festgelegt. Dies ermöglicht den programmatikalischen und rekursiven Zugriff.
 * Die benötigten Daten werden rekursiv aus der XML-Datei gelesen, und in die entsprechende aktuelle Unterhierarchie des root-Model geladen.
 * Dabei gelten folgende Regeln:
 * - Daten bestimmter Model-Klassen sind in Tags mit dem Namen der Model-Klasse enthalten (Name über {@link I_XmlModelEntity#getTag()}
 * - Enthält eine Model-Klasse Properties (einfache Strings), so werden diese als <Property data=""/> gesammelt innerhalb von <Properties></Properties> gespeichert (Properties werden über {@link I_XmlModelEntity#getAllProperties()} abgerufen und durch {@link I_XmlModelEntity#setAllProperties(ArrayList)} gesetzt)
 * - Enthält eine Model-Klasse weitere Model-Klassen (z.B. ModelEntry), so werden diese nach obigen Regeln innerhalb von <children></children> Tags gespeichert (Kindelemente über {@link I_XmlModelEntity#getChildren()}
 */
class XmlImporter implements I_XmlImporter {
    private String _fileName = null;
    private XMLStreamReader _reader = null;
    private I_XmlModelEntity _rootModel = null;

    @Override
    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    @Override
    public void setRootModel(I_XmlModelEntity rootModel) {
        _rootModel = rootModel;
    }

    /**
     * Importiert die beim Erstellen der Klasse angegebene Datei. S. {@link XmlImporter#readXmlRecursively(I_XmlModelEntity)}
     */
    @Override
    public boolean importXml() {
        try {
            _reader = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(_fileName));

            _reader.nextTag();
            readXmlRecursively(_rootModel);

            Log.getLogger().info("XML-Import erfolgreich durchgeführt. Pfad zur Datei: " + _fileName);
            return true;
        } catch (FileNotFoundException e) {
            Log.getLogger()
               .log(
                       Level.SEVERE,
                       "XML-Import nicht erfolgreich abgeschlossen. Datei konnte nicht gefunden werden. " + e.getMessage()
               );
            new InfoDialog(
                    Constants.CONTEXT_TITLE_ERROR,
                    "Fehler beim Laden",
                    "Fehler beim Laden der Datei. Die Datei konnte nicht geöffnet werden.",
                    AlertType.ERROR
            );
        } catch (XMLStreamException ex) {
            Log.getLogger().log(
                    Level.SEVERE,
                    "XML-Import nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage()
            );
            new InfoDialog(
                    Constants.CONTEXT_TITLE_ERROR,
                    "Import fehlgeschlagen",
                    "Import nicht erfolgreich abgeschlossen.",
                    AlertType.ERROR
            );
        } catch (MalformedXmlException ignored) {
            Log.getLogger().log(Level.SEVERE, "Fehler beim Laden. Nicht wohlgeformtes XML-Dokument.");
            new InfoDialog(
                    Constants.CONTEXT_TITLE_ERROR,
                    "Ungültige Datei",
                    "Nicht wohlgeformte Datei. Für den Import muss die Datei zuvor durch ANTool exportiert worden sein.",
                    AlertType.ERROR
            );
        }
        return false;
    }

    /**
     * @return Gibt den aktuellen Tag-Namen zurück.
     */
    private String getCurrentTagName() {
        return _reader.getName().toString();
    }

    /**
     * @return Gibt an, ob der aktuelle Tag ein Startelement ist. (bsp. <Test>)
     */
    private boolean isStartElem() {
        return _reader.getEventType() == XMLStreamConstants.START_ELEMENT;
    }

    /**
     * @return Gibt an, ob der aktuelle Tag ein Endelement ist. (bsp. </Test>)
     */
    private boolean isEndElem() {
        return _reader.getEventType() == XMLStreamConstants.END_ELEMENT;
    }


    /**
     * Traversiert die XML-Elemente und behandelt dabei besondere Tags entsprechend ({@link Constants#XML_CHILDREN_TAG}, {@link Constants#XML_PROPERTIES_TAG}, {@link Constants#XML_PROPERTY_TAG}.
     *
     * @param model Das Model zum jeweiligen XML-Elementbaum.
     * @throws XMLStreamException Falls das Model nicht zum XML-Baum passt, demnach die zu importierende Datei eine nicht valide Struktur enthält (also nicht durch ANTool exportiert, oder nachträglich verändert wurde) wird der Importvorgang abgebrochen.
     */
    private void readXmlRecursively(I_XmlModelEntity model) throws XMLStreamException, MalformedXmlException {
        if (isStartElem()) {
            String rootName = getCurrentTagName();
            if (!model.getTag().equals(rootName)) throw new MalformedXmlException();

            _reader.nextTag();

            while (!(getCurrentTagName().equals(rootName) && isEndElem())) {
                String name = getCurrentTagName();
                if (name.equals(Constants.XML_CHILDREN_TAG)) {
                    if (model.getChildren() != null) {
                        if (!model.getChildren().isEmpty()) {
                            for (I_XmlModelEntity entity : model.getChildren()) {
                                _reader.nextTag();
                                if (isStartElem()) {
                                    readXmlRecursively(entity);
                                }
                            }
                            _reader.nextTag();
                        } else {
                            while (!(getCurrentTagName().equals(name) && isEndElem())) {
                                _reader.nextTag();
                                if (isStartElem() && getCurrentTagName().equals(Constants.XML_PROPERTIES_TAG)) {
                                    model.addEntryWithProperties(processProperties());
                                }
                            }
                        }
                    }
                } else if (name.equals(Constants.XML_PROPERTIES_TAG)) {
                    model.setAllProperties(processProperties());
                }

                _reader.nextTag();
            }
        }
    }

    /**
     * Liest die innerhalb von <Properties></Properties> als einzelne <Property data=""/> angegebenen Daten aus den Properties.
     *
     * @return Gibt die gelesenen Properties als String-ArrayList zurück
     * @throws XMLStreamException Falls allgemeine XML-Fehler auftreten sollten.
     */
    private ArrayList<String> processProperties() throws XMLStreamException {
        _reader.nextTag();
        ArrayList<String> properties = new ArrayList<>();
        while (getCurrentTagName().equals(Constants.XML_PROPERTY_TAG)) {
            if ((_reader.getEventType() != XMLStreamConstants.END_ELEMENT) && (_reader.getAttributeCount() > 0) && _reader
                    .getAttributeName(0)
                    .toString()
                    .equals("data")) {
                properties.add(_reader.getAttributeValue(0));
            }
            _reader.nextTag();
        }
        return properties;
    }

}
