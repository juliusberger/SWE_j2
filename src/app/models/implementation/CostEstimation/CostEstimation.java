package app.models.implementation.CostEstimation;

import app.models.interfaces.CostEstimation.I_CostEstimation;
import app.models.interfaces.CostEstimation.I_CostEstimationEntry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class CostEstimation implements I_CostEstimation {
    private final List<I_CostEstimationEntry> _costEstimationEntries = new ArrayList<>(7);

    public CostEstimation() {
        for (int i = 0; i < 7; i++) {
            this._costEstimationEntries.add(new CostEstimationEntry());
        }
    }

    @Override
    public List<I_CostEstimationEntry> getCostEstimationEntries() {
        return this._costEstimationEntries;
    }

    @Override
    public void exportAsXML(XMLStreamWriter xmlWriter) throws XMLStreamException {

    }

    @Override
    public void importFromXML(XMLStreamReader xmlReader) throws XMLStreamException {
    }

    @Override
    public void removeExistingData() {

    }
}
