package app.model.implementation.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.Requirements.I_FunctionalRequirementEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FunctionalRequirementEntry implements I_FunctionalRequirementEntry {
    private final SimpleStringProperty _function = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");
    private final SimpleStringProperty _stakeholder = new SimpleStringProperty("");

    FunctionalRequirementEntry() {
    }

    @Override
    public String getFunction() {
        return _function.get();
    }

    @Override
    public SimpleStringProperty functionProperty() {
        return _function;
    }

    @Override
    public void setFunction(String function) {
        _function.set(function);
    }

    @Override
    public String getStakeholder() {
        return _stakeholder.get();
    }

    @Override
    public SimpleStringProperty stakeholderProperty() {
        return _stakeholder;
    }

    @Override
    public void setStakeholder(String stakeholder) {
        _stakeholder.set(stakeholder);
    }

    @Override
    public String getDescription() {
        return _description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description.set(description);
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return "FunctionalRequirementEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setFunction(propertyStrings.get(0));
            setDescription(propertyStrings.get(1));
            setStakeholder(propertyStrings.get(2));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getFunction());
        stringProperties.add(getDescription());
        stringProperties.add(getStakeholder());

        return stringProperties;
    }

    //    public String toString() {
//        return "Name: " + getKeyword() + "\nDescription: " + getDescription();
//    }
}
