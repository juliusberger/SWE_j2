package app.models.implementation.Analysis;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by Michi on 23.04.2017.
 */
public class StateAnalysis extends Analysis {

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) {

    }

    @Override
    public boolean importFromXML(XMLStreamReader xmlReader) {
        return false;
    }
}
