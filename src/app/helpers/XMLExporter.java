package app.helpers;

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
    XMLStreamWriter writer;
    String fileName = "";
    XMLOutputFactory factory = XMLOutputFactory.newInstance();

    public XMLExporter(String fileName) {
        this.fileName = fileName;
    }


    public void export()
    {
        try {
            writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter( new FileOutputStream(fileName)));

            // Der XML-Header wird erzeugt
            writer.writeStartDocument();
            writer.writeStartElement("ProjectExport");

            //Einzelne Exports einfügen

            // XML-Datei wird abgeschlossen
            writer.writeEndElement();
            writer.writeEndDocument();

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
