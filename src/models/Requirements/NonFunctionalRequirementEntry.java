package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class NonFunctionalRequirementEntry extends RequirementEntry {
    private final SimpleStringProperty businessProcess;

    public NonFunctionalRequirementEntry(String businessProcess,
                                         String description) {
        super(description);
        this.businessProcess = new SimpleStringProperty(businessProcess);
    }

    public String getBusinessProcess() {
        return businessProcess.get();
    }

    public SimpleStringProperty businessProcessProperty() {
        return businessProcess;
    }

    public void setBusinessProcess(String businessProcess) {
        this.businessProcess.set(businessProcess);
    }


//    public String toString() {
//        return "Name: " + getBusinessProcess() + "\nDescription: " + getDescription();
//    }
}
