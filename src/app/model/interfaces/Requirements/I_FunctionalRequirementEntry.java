package app.model.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle der funktionalen Anforderungen.
 */
public interface I_FunctionalRequirementEntry extends I_RequirementEntry {
    String getFunction();

    SimpleStringProperty functionProperty();

    void setFunction(String function);

    String getStakeholder();

    SimpleStringProperty stakeholderProperty();

    void setStakeholder(String stakeholder);
}
