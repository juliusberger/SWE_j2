package app.model.implementation.ProjectData;

import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.ProjectData.I_Customer;
import app.model.interfaces.ProjectData.I_ProjectData;
import app.model.interfaces.ProjectData.I_ProjectEditor;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class ProjectData implements I_ProjectData {
    private final SimpleStringProperty _name = new SimpleStringProperty("");
    private final SimpleStringProperty _dueDate = new SimpleStringProperty("");

    private final I_ProjectEditor _projectEditor = new ProjectEditor();

    private final I_Customer _customer = new Customer();

    public ProjectData() {
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
    public String getDueDate() {
        return _dueDate.get();
    }

    @Override
    public void setDueDate(String dueDate) {
        _dueDate.set(dueDate);
    }

    @Override
    public SimpleStringProperty dueDateProperty() {
        return _dueDate;
    }

    @Override
    public I_ProjectEditor getProjectEditor() {
        return _projectEditor;
    }

    @Override
    public I_Customer getCustomer() {
        return _customer;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        List<I_XmlModelEntity> children = new ArrayList<>(2);
        children.add(getProjectEditor());
        children.add(getCustomer());
        return children;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "ProjectData";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getName());
        stringProperties.add(getDueDate());

        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setName(propertyStrings.get(0));
            setDueDate(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public void removeExistingData() {
        setName("");
        setDueDate("");
        getCustomer().removeExistingData();
        getProjectEditor().removeExistingData();
    }
}
