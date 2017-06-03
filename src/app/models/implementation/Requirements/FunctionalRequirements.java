package app.models.implementation.Requirements;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Requirements.I_FunctionalRequirementEntry;
import app.models.interfaces.Requirements.I_FunctionalRequirements;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by Michi on 23.04.2017.
 */
class FunctionalRequirements extends ObservableEntryHolder<I_FunctionalRequirementEntry> implements I_FunctionalRequirements {
    @Override
    public I_FunctionalRequirementEntry createEntry() {
        return new FunctionalRequirementEntry();
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("FunctionalRequirements");

        for(I_FunctionalRequirementEntry currentEntry : this.getEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("FunctionalRequirementsEntry");
            xmlWriter.writeAttribute("function",
                    currentEntry.getFunction());
            xmlWriter.writeAttribute("descritpion",
                    currentEntry.getDescription());
            xmlWriter.writeAttribute("stakeholder",
                    currentEntry.getStakeholder());
            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {

    }
}
