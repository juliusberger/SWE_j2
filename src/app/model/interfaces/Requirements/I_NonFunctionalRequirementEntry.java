package app.model.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle der nicht-funktionalen Anforderungen.
 */
public interface I_NonFunctionalRequirementEntry extends I_RequirementEntry {
    String getBusinessProcess();

    void setBusinessProcess(String businessProcess);

    SimpleStringProperty businessProcessProperty();
}
