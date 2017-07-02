package app.model.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle der funktionalen Anforderungen.
 */
public interface I_FunctionalRequirementEntry extends I_RequirementEntry {
    String getFunction();

    void setFunction(String function);

    SimpleStringProperty functionProperty();

    String getStakeholder();

    void setStakeholder(String stakeholder);

    SimpleStringProperty stakeholderProperty();
}
