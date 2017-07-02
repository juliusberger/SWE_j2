package app.model.implementation.ProjectData;

import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.ProjectData.I_ProjectEditor;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_ProjectEditor}
 */
class ProjectEditor implements I_ProjectEditor {
    private final SimpleStringProperty _surname = new SimpleStringProperty("");
    private final SimpleStringProperty _name = new SimpleStringProperty("");

    @Override
    public String getSurname() {
        return _surname.get();
    }

    @Override
    public void setSurname(String surname) {
        _surname.set(surname);
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return _surname;
    }

    @Override
    public String getName() {
        return _name.get();
    }

    @Override
    public void setName(String name) {
        _name.set(name);
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return _name;
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
        return "ProjectEditor";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getSurname());
        stringProperties.add(getName());

        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setSurname(propertyStrings.get(0));
            setName(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public void removeExistingData() {
        setSurname("");
        setName("");
    }
}
