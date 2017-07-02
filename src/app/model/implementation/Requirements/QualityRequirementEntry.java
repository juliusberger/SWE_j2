package app.model.implementation.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_QualityRequirementEntry;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_QualityRequirementEntry}
 */
class QualityRequirementEntry implements I_QualityRequirementEntry {
    private final SimpleObjectProperty<Priority> _priority = new SimpleObjectProperty<>(Priority.UNSET);

    @Override
    public SimpleObjectProperty<Priority> priorityProperty() {
        return _priority;
    }

    @Override
    public Priority getPriority() {
        return _priority.get();
    }

    @Override
    public void setPriority(Priority priority) {
        _priority.set(priority);
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
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        if (getPriority() != null) stringProperties.add(getPriority().toString());
        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setPriority(Priority.valueOf(propertyStrings.get(0)));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public void removeExistingData() {
        setPriority(Priority.UNSET);
    }
}
