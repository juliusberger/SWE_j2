package app.model.implementation.Requirements;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_NonFunctionalRequirementEntry;
import app.model.interfaces.Requirements.I_NonFunctionalRequirements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michi on 23.04.2017.
 */
class NonFunctionalRequirements extends ObservableEntryHolder<I_NonFunctionalRequirementEntry> implements I_NonFunctionalRequirements {
    @Override
    public I_NonFunctionalRequirementEntry createEntry() {
        return new NonFunctionalRequirementEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public String getTag() {
        return "NonFunctionalRequirements";
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
        return new String[]{"businessProcess","description"};
    }
}
