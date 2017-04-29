package models.ProjectData;

import javafx.beans.property.SimpleStringProperty;
import models.Customer.I_Customer;
import models.ProjectEditor.I_ProjectEditor;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class ProjectData implements I_ProjectData {
    private final SimpleStringProperty name;
    private final SimpleStringProperty dueDate;

    private final I_ProjectEditor IProjectEditor;

    private final I_Customer ICustomer;

    public ProjectData(String name,
                       String dueDate,
                       I_ProjectEditor IProjectEditor,
                       I_Customer ICustomer)
    {
        this.name = new SimpleStringProperty(name);
        this.dueDate = new SimpleStringProperty(dueDate);

        this.IProjectEditor = IProjectEditor;

        this.ICustomer = ICustomer;
    }

    @Override
    public String getName() {
        return this.name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String getDueDate() {
        return this.dueDate.get();
    }

    @Override
    public SimpleStringProperty dueDateProperty() {
        return this.dueDate;
    }

    @Override
    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    @Override
    public I_ProjectEditor getProjectEditor()
    {
        return this.IProjectEditor;
    }

    @Override
    public I_Customer getCustomer()
    {
        return this.ICustomer;
    }
}
