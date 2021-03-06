package app.model.implementation.CostEstimation;

import app.model.interfaces.CostEstimation.I_CostEstimation;
import app.model.interfaces.CostEstimation.I_CostEstimationEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model-Implementierung von {@link I_CostEstimation}
 */
public class CostEstimation implements I_CostEstimation {

    private final List<I_CostEstimationEntry> _costEstimationEntries = new ArrayList<>(9);

    public CostEstimation() {
        for (int i = 0; i <= 9; i++) {
            _costEstimationEntries.add(new CostEstimationEntry());
        }
    }

    @Override
    public List<I_CostEstimationEntry> getCostEstimationEntries() {
        return Collections.unmodifiableList(_costEstimationEntries);
    }

    @Override
    public void removeExistingData() {
        _costEstimationEntries.forEach(entry -> entry.setWeight(""));
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getCostEstimationEntries());
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {
    }

    @Override
    public String getTag() {
        return "CostEstimation";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }
}
