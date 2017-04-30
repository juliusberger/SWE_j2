package models.implementation.Requirements;

import javafx.beans.property.SimpleStringProperty;
import models.interfaces.Requirements.I_FunctionalRequirementEntry;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FunctionalRequirementEntry implements I_FunctionalRequirementEntry {
    private final SimpleStringProperty _function = new SimpleStringProperty();
    private final SimpleStringProperty _description = new SimpleStringProperty();
    private final SimpleStringProperty _stakeholder = new SimpleStringProperty();

    FunctionalRequirementEntry() {
    }

    @Override
    public String getFunction() {
        return this._function.get();
    }

    @Override
    public SimpleStringProperty functionProperty() {
        return this._function;
    }

    @Override
    public void setFunction(String function) {
        this._function.set(function);
    }

    @Override
    public String getStakeholder() {
        return this._stakeholder.get();
    }

    @Override
    public SimpleStringProperty stakeholderProperty() {
        return this._stakeholder;
    }

    @Override
    public void setStakeholder(String stakeholder) {
        this._stakeholder.set(stakeholder);
    }

    @Override
    public String getDescription() {
        return this._description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this._description;
    }

    @Override
    public void setDescription(String description) {
        this._description.set(description);
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            this.setFunction(propertyStrings.get(0));
            this.setDescription(propertyStrings.get(1));
            this.setStakeholder(propertyStrings.get(2));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getFunction());
        stringProperties.add(this.getDescription());
        stringProperties.add(this.getStakeholder());

        return stringProperties;
    }

    //    public String toString() {
//        return "Name: " + getKeyword() + "\nDescription: " + getDescription();
//    }
}
