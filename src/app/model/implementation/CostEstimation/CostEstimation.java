package app.model.implementation.CostEstimation;

import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_CostEstimation;
import app.model.interfaces.CostEstimation.I_CostEstimationEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public class CostEstimation implements I_CostEstimation {

    private final List<I_CostEstimationEntry> _costEstimationEntries = new ArrayList<>(7);

    private final I_Classification _classification = new Classification();

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
    public void removeExistingData() {

    }

    @Override
    public I_Classification getClassification() {
        return this._classification;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }
}
