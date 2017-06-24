package app.model.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_NonFunctionalRequirementEntry extends I_RequirementEntry {
    String getBusinessProcess();

    SimpleStringProperty businessProcessProperty();

    void setBusinessProcess(String businessProcess);
}
