package app.model.implementation.Analysis;

import app.model.interfaces.Analysis.I_AnalysisEntry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
public class StateAnalysis extends Analysis {

    @Override
    public String getTag() {
        return "StateAnalysis";
    }

    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("StateAnalysisProperties");

        for(I_AnalysisEntry currentEntry : this.getEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("StateAnalysisEntry");
            xmlWriter.writeAttribute("entryName",
                    currentEntry.getEntryName());
            xmlWriter.writeAttribute("description",
                    currentEntry.getDescription());
            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
    }

    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        ArrayList<String> stateAnalysisEntryArguments = new ArrayList<>();
        stateAnalysisEntryArguments.add(xmlReader.getAttributeValue(0));
        stateAnalysisEntryArguments.add(xmlReader.getAttributeValue(1));
        this.addEntryWithProperties(stateAnalysisEntryArguments);
    }

    public void removeExistingData() {
        this.getEntries().clear();
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"entryName", "description"};
    }
}
