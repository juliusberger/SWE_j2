package app.models.interfaces;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by Michi on 02.06.2017.
 */
public interface I_XMLExportable {
    void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException;
}
