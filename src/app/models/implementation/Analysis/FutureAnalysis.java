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
    public String getTag() {
        return "FutureAnalysis";
    }


    public void removeExistingData() {
        this.getEntries().clear();
    }
}
