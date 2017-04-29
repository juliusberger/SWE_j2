package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class NonFunctionalRequirementEntry implements I_NonFunctionalRequirementEntry {
    private final SimpleStringProperty businessProcess;
    private final SimpleStringProperty description;

    NonFunctionalRequirementEntry(String businessProcess,
                                  String description) {
        this.businessProcess = new SimpleStringProperty(businessProcess);
        this.description = new SimpleStringProperty(description);
    }

    @Override
    public String getBusinessProcess() {
        return this.businessProcess.get();
    }

    @Override
    public SimpleStringProperty businessProcessProperty() {
        return this.businessProcess;
    }

    @Override
    public void setBusinessProcess(String businessProcess) {
        this.businessProcess.set(businessProcess);
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

}
