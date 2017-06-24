package app.models.implementation.CostEstimation;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.CostEstimation.I_Classification;
import app.models.interfaces.CostEstimation.I_ClassificationEntry;
import app.models.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthias on 24.06.2017.
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
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void removeExistingData() {
        this.getEntries().clear();
    }
}