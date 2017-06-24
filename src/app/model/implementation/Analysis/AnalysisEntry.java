package app.model.implementation.Analysis;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.Analysis.I_AnalysisEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class AnalysisEntry implements I_AnalysisEntry {
    private final SimpleStringProperty _entryName = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");

    AnalysisEntry() {
    }

    @Override
    public String getEntryName() {
        return this._entryName.get();
    }

    @Override
    public SimpleStringProperty entryNameProperty() {
        return this._entryName;
    }

    @Override
    public void setEntryName(String entryName) {
        this._entryName.set(entryName);
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
        return "AnalysisEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            this.setEntryName(propertyStrings.get(0));
            this.setDescription(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getEntryName());
        stringProperties.add(this.getDescription());

        return stringProperties;
    }
}
