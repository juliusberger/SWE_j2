package app.model.implementation.Analysis;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.Analysis.I_AnalysisEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_AnalysisEntry}
 */
public class AnalysisEntry implements I_AnalysisEntry {
    private final SimpleStringProperty _entryName = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");

    @Override
    public String getEntryName() {
        return _entryName.get();
    }

    @Override
    public SimpleStringProperty entryNameProperty() {
        return _entryName;
    }

    @Override
    public void setEntryName(String entryName) {
        _entryName.set(entryName);
    }

    @Override
    public String getDescription() {
        return _description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description.set(description);
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "AnalysisEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setEntryName(propertyStrings.get(0));
            setDescription(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getEntryName());
        stringProperties.add(getDescription());

        return stringProperties;
    }
}
