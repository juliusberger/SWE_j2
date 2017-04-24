package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FunctionalRequirementEntry extends RequirementEntry {
    private final SimpleStringProperty function;
    private final SimpleStringProperty stakeholder;

    FunctionalRequirementEntry(String function,
                               String description,
                               String stakeholder) {
        super(description);
        this.function = new SimpleStringProperty(function);
        this.stakeholder = new SimpleStringProperty(stakeholder);
    }

    String getFunction() {
        return this.function.get();
    }

    public SimpleStringProperty functionProperty() {
        return this.function;
    }

    void setFunction(String function) {
        this.function.set(function);
    }

    String getStakeholder() {
        return this.stakeholder.get();
    }

    public SimpleStringProperty stakeholderProperty() {
        return this.stakeholder;
    }

    void setStakeholder(String stakeholder) {
        this.stakeholder.set(stakeholder);
    }

//    public String toString() {
//        return "Name: " + getKeyword() + "\nDescription: " + getDescription();
//    }
}
