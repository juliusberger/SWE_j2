package app.helpers.importExport;

import app.Constants;
import app.InfoDialog;
import app.Log;
import app.model.implementation.Project;
import app.model.interfaces.I_Project;
import app.model.interfaces.I_XmlModelEntity;
import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;
import javafx.scene.control.Alert;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;

/**
 * Created by Michi on 03.06.2017.
 */
public class XmlExporter implements I_XmlExporter {
    private final String _fileName;
    private XMLStreamWriter _writer;

    public XmlExporter(String fileName) {
        _fileName = fileName;
    }

    private void writeXmlRecursively(I_XmlModelEntity entity) throws XMLStreamException {
        _writer.writeStartElement(entity.getTag());

        if (entity.getAllProperties() != null) {
            _writer.writeStartElement("Properties");

            for (String property : entity.getAllProperties()) {
                _writer.writeEmptyElement("Property");
                _writer.writeAttribute("data",
                        property);
            }

            _writer.writeEndElement();
        }
        if (entity.getChildren() != null && entity.getChildren().size() > 0) {
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
        try {
            _writer = new IndentingXMLStreamWriter(XMLOutputFactory.newFactory().createXMLStreamWriter(new FileOutputStream(
                    _fileName)));

            _writer.writeStartDocument();

            I_Project project = Project.getInstance();
            writeXmlRecursively(project);

            _writer.writeEndDocument();

            Log.getLogger().info("XML-Export erfolgreich durchgeführt. Pfad zur Datei: " + _fileName);
            return true;
        } catch (XMLStreamException ex) {
            Log.getLogger()
                    .log(Level.SEVERE, "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());

            InfoDialog.show(Constants.CONTEXT_TITLE_ERROR, "Export fehlgeschlagen",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage(), Alert.AlertType.ERROR);
        } catch (FileNotFoundException e) {
            Log.getLogger()
                    .log(Level.SEVERE, "XML-Export nicht erfolgreich abgeschlossen. Datei konnte nicht erstellt werden. " + e.getMessage());
            InfoDialog.show(Constants.CONTEXT_TITLE_ERROR, "Fehler beim Speichern",
                    "Fehler beim Speichern der Datei. Die Datei konnte nicht erstellt werden.", Alert.AlertType.ERROR);
        }
        return false;
    }
}
