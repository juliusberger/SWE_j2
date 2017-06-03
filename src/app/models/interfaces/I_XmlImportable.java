package app.models.interfaces;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by Michi on 02.06.2017.
 */
public interface I_XMLImportable {
    void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException;
}
