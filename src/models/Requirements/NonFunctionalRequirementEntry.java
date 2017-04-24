package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class NonFunctionalRequirementEntry extends RequirementEntry {
    private final SimpleStringProperty businessProcess;

    NonFunctionalRequirementEntry(String businessProcess,
                                  String description) {
        super(description);
        this.businessProcess = new SimpleStringProperty(businessProcess);
    }

    String getBusinessProcess() {
        return this.businessProcess.get();
    }

    public SimpleStringProperty businessProcessProperty() {
        return this.businessProcess;
    }

    void setBusinessProcess(String businessProcess) {
        this.businessProcess.set(businessProcess);
    }


//    public String toString() {
//        return "Name: " + getBusinessProcess() + "\nDescription: " + getDescription();
//    }
}
