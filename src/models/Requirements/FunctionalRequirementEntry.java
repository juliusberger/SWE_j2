package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FunctionalRequirementEntry implements I_FunctionalRequirementEntry {
    private final SimpleStringProperty function;
    private final SimpleStringProperty description;
    private final SimpleStringProperty stakeholder;

    FunctionalRequirementEntry(String function,
                               String description,
                               String stakeholder) {
        this.function = new SimpleStringProperty(function);
        this.description = new SimpleStringProperty(description);
        this.stakeholder = new SimpleStringProperty(stakeholder);
    }

    @Override
    public String getFunction() {
        return this.function.get();
    }

    @Override
    public SimpleStringProperty functionProperty() {
        return this.function;
    }

    @Override
    public void setFunction(String function) {
        this.function.set(function);
    }

    @Override
    public String getStakeholder() {
        return this.stakeholder.get();
    }

    @Override
    public SimpleStringProperty stakeholderProperty() {
        return this.stakeholder;
    }

    @Override
    public void setStakeholder(String stakeholder) {
        this.stakeholder.set(stakeholder);
    }

    @Override
    public String getDescription() {
        return this.description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description.set(description);
    }

//    public String toString() {
//        return "Name: " + getKeyword() + "\nDescription: " + getDescription();
//    }
}
