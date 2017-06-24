package app.model.implementation.Requirements;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_FunctionalRequirementEntry;
import app.model.interfaces.Requirements.I_FunctionalRequirements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michi on 23.04.2017.
 */
class FunctionalRequirements extends ObservableEntryHolder<I_FunctionalRequirementEntry> implements I_FunctionalRequirements {
    @Override
    public I_FunctionalRequirementEntry createEntry() {
        return new FunctionalRequirementEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public String getTag() {
        return "FunctionalRequirements";
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

    @Override
    public String[] getPropertyNames() {
        return new String[]{"function", "description", "stakeholder"};
    }
}
