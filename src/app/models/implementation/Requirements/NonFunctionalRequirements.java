package app.models.implementation.Requirements;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Requirements.I_NonFunctionalRequirementEntry;
import app.models.interfaces.Requirements.I_NonFunctionalRequirements;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
class NonFunctionalRequirements extends ObservableEntryHolder<I_NonFunctionalRequirementEntry> implements I_NonFunctionalRequirements {
    @Override
    public I_NonFunctionalRequirementEntry createEntry() {
        return new NonFunctionalRequirementEntry();
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("NonFunctionalRequirements");

        for(I_NonFunctionalRequirementEntry currentEntry : this.getEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("NonFunctionalRequirementsEntry");
            xmlWriter.writeAttribute("businessProcess",
                    currentEntry.getBusinessProcess());
            xmlWriter.writeAttribute("description",
                    currentEntry.getDescription());
            xmlWriter.writeEndElement();
        }

        xmlWriter.writeEndElement();
    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        ArrayList<String> nonFunctionalRequirementsEntryArguments = new ArrayList<>();
        nonFunctionalRequirementsEntryArguments.add(xmlReader.getAttributeValue(0));
        nonFunctionalRequirementsEntryArguments.add(xmlReader.getAttributeValue(1));
        this.addEntryWithProperties(nonFunctionalRequirementsEntryArguments);
    }

    @Override
    public void removeExistingData() {
        this.getEntries().clear();
    }
}
