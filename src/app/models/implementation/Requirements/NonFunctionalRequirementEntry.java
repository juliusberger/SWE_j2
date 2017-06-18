package app.models.implementation.Requirements;

import app.models.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.Requirements.I_NonFunctionalRequirementEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class NonFunctionalRequirementEntry implements I_NonFunctionalRequirementEntry {
    private final SimpleStringProperty _businessProcess = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");

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
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return "NonFunctionalRequirementsEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            this.setBusinessProcess(propertyStrings.get(0));
            this.setDescription(propertyStrings.get(1));
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
