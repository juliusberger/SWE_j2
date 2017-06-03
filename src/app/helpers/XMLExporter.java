package app.helpers;

import app.models.implementation.Project;
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
    XMLStreamWriter xmlWriter;
    String fileName = "";
    XMLOutputFactory factory = XMLOutputFactory.newInstance();

    public XMLExporter(String fileName) {
        this.fileName = fileName;
    }


    public void exportToXML()
    {
        try {
            xmlWriter = new IndentingXMLStreamWriter(factory.createXMLStreamWriter( new FileOutputStream(fileName)));

            // Der XML-Header wird erzeugt
            xmlWriter.writeStartDocument();
            xmlWriter.writeStartElement("ProjectExport");

            //TODO: CostEstimation einfügen
            Project.getInstance().exportAsXML(xmlWriter);
            Project.getInstance().getProjectData().exportAsXML(xmlWriter);
            Project.getInstance().getStateAnalysis().exportAsXML(xmlWriter);
            Project.getInstance().getFutureAnalysis().exportAsXML(xmlWriter);
            Project.getInstance().getRequirements().exportAsXML(xmlWriter);
            Project.getInstance().getGlossary().exportAsXML(xmlWriter);

            // XML-Datei wird abgeschlossen
            xmlWriter.writeEndElement();
            xmlWriter.writeEndDocument();

            System.out.println("XML-Datei erfolgreich erstellt");
            LogWriter.writeLog("XML-Export wurde erfolgreich erstellt. Pfad zur Datei: " + fileName);
            InfoDialog dialog = new InfoDialog("XML-Export erfolgreich",
                    "XML-Export erfolgreich abgeschlossen");


        }
        catch (FileNotFoundException ex)
        {
            LogWriter.writeLog("XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog dialog = new InfoDialog("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
        catch (XMLStreamException ex)
        {
            LogWriter.writeLog("XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf: " + ex.getMessage());
            InfoDialog dialog = new InfoDialog("XML-Export nicht erfolgreich",
                    "XML-Export nicht erfolgreich abgeschlossen. Folgender Fehler trat auf:\n" + ex.getMessage());
        }
    }
}
