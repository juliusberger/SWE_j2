package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class ProjectData
{
    private final SimpleStringProperty name;
    private final SimpleStringProperty dueDate;

    private final ProjectEditor projectEditor;

    private final Customer customer;

    public ProjectData(String name,
                       String dueDate,
                       ProjectEditor projectEditor,
                       Customer customer)
    {
        this.name = new SimpleStringProperty(name);
        this.dueDate = new SimpleStringProperty(dueDate);

        this.projectEditor = projectEditor;

        this.customer = customer;
    }

    public String getName()
    {
        return name.get();
    }

    public SimpleStringProperty nameProperty()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public String getDueDate()
    {
        return dueDate.get();
    }

    public SimpleStringProperty dueDateProperty()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate.set(dueDate);
    }

    public ProjectEditor getProjectEditor()
    {
        return projectEditor;
    }

    public Customer getCustomer()
    {
        return customer;
    }
}
