package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class NonFunctionalRequirementEntry implements I_NonFunctionalRequirementEntry {
    private final SimpleStringProperty _businessProcess = new SimpleStringProperty();
    private final SimpleStringProperty _description = new SimpleStringProperty();

    NonFunctionalRequirementEntry() {
    }

    @Override
    public String getBusinessProcess() {
        return this._businessProcess.get();
    }

    @Override
    public SimpleStringProperty businessProcessProperty() {
        return this._businessProcess;
    }

    @Override
    public void setBusinessProcess(String businessProcess) {
        this._businessProcess.set(businessProcess);
    }

    @Override
    public String getDescription() {
        return this._description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this._description;
    }

    @Override
    public void setDescription(String description) {
        this._description.set(description);
    }


    @Override
    public void setAllProperties(ArrayList<String> dataStrings) {
        try {
            this.setBusinessProcess(dataStrings.get(0));
            this.setDescription(dataStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getBusinessProcess());
        stringProperties.add(this.getDescription());

        return stringProperties;
    }
}
