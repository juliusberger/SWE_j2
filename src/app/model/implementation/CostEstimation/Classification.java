package app.model.implementation.CostEstimation;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_Classification}
 */
public class Classification extends ObservableEntryHolder<I_ClassificationEntry> implements I_Classification {

    @Override
    public I_ClassificationEntry createEntry() {
        return new ClassificationEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public String getTag() {
        return "Classification";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"function", "description", "stakeholder", "category", "classification"};
    }
}
