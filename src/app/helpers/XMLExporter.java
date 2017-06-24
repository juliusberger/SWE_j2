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
public class XMLExporter {
    private String _fileName = "";

    public XMLExporter(String fileName) {
        this._fileName = fileName;
    }

    private static void writeXmlRecursively(XMLStreamWriter writer, I_XmlModelEntity entity) throws XMLStreamException {
        writer.writeStartElement(entity.getTag());

        if (entity.getAllProperties() != null) {
            writer.writeStartElement("Properties");

            for (String property : entity.getAllProperties()) {
                writer.writeEmptyElement("Property");
                writer.writeAttribute("data",
                        property);
            }

            writer.writeEndElement();
        }
        if (entity.getChildren() != null && entity.getChildren().size() > 0) {
            writer.writeStartElement("Children");

            for (I_XmlModelEntity modelEntity : entity.getChildren()) {
                writeXmlRecursively(writer, modelEntity);
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }

    public void exportXML() {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(new FileOutputStream(
                    _fileName)));

            writer.writeStartDocument();

            I_Project project = Project.getInstance();
            writeXmlRecursively(writer, project);

            writer.writeEndDocument();

            //TODO: Konsolen-Ausgabebefehl löschen, wenn nicht mehr zu Debugging-Zwecken notwendig
            Log.getLogger().info("XML-Export wurde erfolgreich erstellt. Pfad zur Datei: " + _fileName);
            InfoDialog dialog = new InfoDialog("XML-Export erfolgreich",
                    "XML-Export erfolgreich abgeschlossen");
            // TODO: Statischer dialog


        } catch (FileNotFoundException | XMLStreamException ex) {
            Log.getLogger()
                    .info("XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog dialog = new InfoDialog("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }
}
