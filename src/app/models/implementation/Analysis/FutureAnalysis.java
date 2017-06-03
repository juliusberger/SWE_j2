package app.models.implementation.Analysis;

import app.models.interfaces.Analysis.I_AnalysisEntry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
public class FutureAnalysis extends Analysis {

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("FutureAnalysisProperties");

        for(I_AnalysisEntry currentEntry : this.getEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("FutureAnalysisEntry");
            xmlWriter.writeAttribute("entryName",
                    currentEntry.getEntryName());
            xmlWriter.writeAttribute("description",
                    currentEntry.getDescription());
            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        ArrayList<String> futureAnalysisEntryArguments = new ArrayList<>();
        futureAnalysisEntryArguments.add(xmlReader.getAttributeValue(0));
        futureAnalysisEntryArguments.add(xmlReader.getAttributeValue(1));
        this.addEntryWithProperties(futureAnalysisEntryArguments);
    }
}
