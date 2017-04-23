package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FunctionalRequirementEntry extends RequirementEntry {
    private final SimpleStringProperty function;
    private final SimpleStringProperty stakeholder;

    public FunctionalRequirementEntry(String function,
                                      String stakeholder,
                                      String description) {
        super(description);
        this.function = new SimpleStringProperty(function);
        this.stakeholder = new SimpleStringProperty(stakeholder);
    }

    public String getFunction() {
        return function.get();
    }

    public SimpleStringProperty functionProperty() {
        return function;
    }

    public void setFunction(String function) {
        this.function.set(function);
    }

    public String getStakeholder() {
        return stakeholder.get();
    }

    public SimpleStringProperty stakeholderProperty() {
        return stakeholder;
    }

    public void setStakeholder(String stakeholder) {
        this.stakeholder.set(stakeholder);
    }

//    public String toString() {
//        return "Name: " + getKeyword() + "\nDescription: " + getDescription();
//    }
}
