package app.helpers.importExport;

import app.Constants;
import app.InfoDialog;
import app.Log;
import app.model.interfaces.I_XmlModelEntity;
import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import javafx.scene.control.Alert.AlertType;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Diese Klasse implementiert die zu {@link I_XmlExporter} gehörige Export-Funktion.
 * Dazu wird die festgelegte Datei, und das root-Model als Einstiegspunkt genutzt.
 * Die benötigten Model-Repräsentationen für den Import/Export sind durch {@link I_XmlModelEntity} festgelegt. Dies ermöglicht den programmatikalischen und rekursiven Zugriff.
 * Die benötigten Daten werden rekursiv aus den Models mit dem Einstiegspunkt des root-Model geholt, und in entsprechende Tags geschrieben.
 * Dabei gelten folgende Regeln:
 * - Daten bestimmter Model-Klassen sind in Tags mit dem Namen der Model-Klasse enthalten (Name über {@link I_XmlModelEntity#getTag()}
 * - Enthält eine Model-Klasse Properties (einfache Strings), so werden diese als <Property data=""/> gesammelt innerhalb von <Properties></Properties> gespeichert (Properties werden über {@link I_XmlModelEntity#getAllProperties()} abgerufen und durch {@link I_XmlModelEntity#setAllProperties(ArrayList)} gesetzt)
 * - Enthält eine Model-Klasse weitere Model-Klassen (z.B. ModelEntry), so werden diese nach obigen Regeln innerhalb von <children></children> Tags gespeichert (Kindelemente über {@link I_XmlModelEntity#getChildren()}
 */
class XmlExporter implements I_XmlExporter {
    private String _fileName = null;
    private XMLStreamWriter _writer = null;
    private I_XmlModelEntity _rootModel = null;

    @Override
    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    @Override
    public void setRootModel(I_XmlModelEntity rootModel) {
        _rootModel = rootModel;
    }

    private void writeXmlRecursively(I_XmlModelEntity entity) throws XMLStreamException {
        _writer.writeStartElement(entity.getTag());

        if (entity.getAllProperties() != null) {
            _writer.writeStartElement("Properties");

            for (String property : entity.getAllProperties()) {
                _writer.writeEmptyElement("Property");
                _writer.writeAttribute("data", property);
            }

            _writer.writeEndElement();
        }
        if ((entity.getChildren() != null) && !entity.getChildren().isEmpty()) {
            _writer.writeStartElement("Children");

            for (I_XmlModelEntity modelEntity : entity.getChildren()) {
                writeXmlRecursively(modelEntity);
            }

            _writer.writeEndElement();
        }

        _writer.writeEndElement();
    }

    @Override
    public boolean exportXml() {
        if ((_rootModel != null) && (_fileName != null)) {
            try {
                _writer = new IndentingXMLStreamWriter(XMLOutputFactory.newFactory().createXMLStreamWriter(new FileOutputStream(_fileName)));

                _writer.writeStartDocument();

                writeXmlRecursively(_rootModel);

                _writer.writeEndDocument();

                Log.getLogger().info("XML-Export erfolgreich durchgeführt. Pfad zur Datei: " + _fileName);
                return true;
            } catch (XMLStreamException ex) {
                Log.getLogger().log(Level.SEVERE, "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
                InfoDialog.show(Constants.CONTEXT_TITLE_ERROR, "Export fehlgeschlagen", "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage(), AlertType.ERROR);
            } catch (FileNotFoundException e) {
                Log.getLogger().log(Level.SEVERE, "XML-Export nicht erfolgreich abgeschlossen. Datei konnte nicht erstellt werden. " + e.getMessage());
                InfoDialog.show(Constants.CONTEXT_TITLE_ERROR, "Fehler beim Speichern", "Fehler beim Speichern der Datei. Die Datei konnte nicht erstellt werden.", AlertType.ERROR);
            }
        }
        return false;
    }
}
