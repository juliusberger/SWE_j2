package app.helpers;

import app.model.implementation.Project;
import app.model.interfaces.I_Project;
import app.model.interfaces.I_XmlModelEntity;
import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Michi on 03.06.2017.
 */
public class XmlExporter implements I_XmlExporter {
    private String _fileName;
    private XMLStreamWriter _writer;

    public XmlExporter(String fileName) {
        _fileName = fileName;
        try {
            _writer = new IndentingXMLStreamWriter(XMLOutputFactory.newFactory().createXMLStreamWriter(new FileOutputStream(
                    fileName)));
        } catch (XMLStreamException e) {
            Log.getLogger()
                    .info("XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + e.getMessage());
            InfoDialog.show("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + e.getMessage());
        } catch (FileNotFoundException e) {
            Log.getLogger()
                    .info("XML-Export nicht erfolgreich abgeschlossen. Datei konnte nicht erstellt werden. " + e.getMessage());
            InfoDialog.show("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Datei konnte nicht erstellt werden. \n" + e.getMessage());
        }

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
    public void exportXml() {
        try {

            _writer.writeStartDocument();

            I_Project project = Project.getInstance();
            writeXmlRecursively(project);

            _writer.writeEndDocument();

            //TODO: Konsolen-Ausgabebefehl löschen, wenn nicht mehr zu Debugging-Zwecken notwendig
            Log.getLogger().info("XML-Export wurde erfolgreich erstellt. Pfad zur Datei: " + _fileName);
            InfoDialog.show("XML-Export erfolgreich",
                    "XML-Export erfolgreich abgeschlossen");
            // TODO: Statischer dialog


        } catch (XMLStreamException ex) {
            Log.getLogger()
                    .info("XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog.show("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }
}
