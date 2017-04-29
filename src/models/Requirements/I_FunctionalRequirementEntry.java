package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_FunctionalRequirementEntry extends I_RequirementEntry {
    String getFunction();

    SimpleStringProperty functionProperty();

    void setFunction(String function);

    String getStakeholder();

    SimpleStringProperty stakeholderProperty();

    void setStakeholder(String stakeholder);
}
