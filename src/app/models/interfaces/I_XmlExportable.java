package app.models.interfaces;

import javax.xml.stream.XMLStreamWriter;

/**
 * Created by Michi on 02.06.2017.
 */
public interface I_XmlExportable {
    void exportAsXML(XMLStreamWriter xmlWriter);
}
