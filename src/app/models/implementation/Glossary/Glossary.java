package app.models.implementation.Glossary;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.Glossary.I_GlossaryEntry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary extends ObservableEntryHolder<I_GlossaryEntry> implements I_Glossary {
    @Override
    public I_GlossaryEntry createEntry() {
        return new GlossaryEntry();
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("GlossaryProperties");

        for(I_GlossaryEntry currentEntry : this.getEntries())
        {
            xmlWriter.writeCharacters("\t");
            xmlWriter.writeStartElement("GlossaryEntry");
            xmlWriter.writeAttribute("item",
                    currentEntry.getItem());
            xmlWriter.writeAttribute("definition",
                    currentEntry.getDefinition());
            xmlWriter.writeEndElement();
        }
        xmlWriter.writeEndElement();

    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
        ArrayList<String> glossaryEntryArguments = new ArrayList<>();
        glossaryEntryArguments.add(xmlReader.getAttributeValue(0));
        glossaryEntryArguments.add(xmlReader.getAttributeValue(1));
        this.addEntryWithProperties(glossaryEntryArguments);
    }

    @Override
    public void removeExistingData() {
        this.getEntries().clear();
    }
}
