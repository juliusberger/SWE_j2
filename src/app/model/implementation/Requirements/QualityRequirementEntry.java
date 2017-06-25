package app.model.implementation.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_QualityRequirementEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michi on 23.04.2017.
 */
class QualityRequirementEntry implements I_QualityRequirementEntry {
    private Priority _priority;


    @Override
    public Priority getPriority() {
        return _priority;
    }

    @Override
    public void setPriority(Priority priority) {
        _priority = priority;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "QualityRequirementEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setPriority(Priority.valueOf(propertyStrings.get(0)));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        if (getPriority() != null)
            stringProperties.add(getPriority().toString());
        return stringProperties;
    }
}
