package models.ProjectEditor;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class ProjectEditor
{
    private SimpleStringProperty surname;
    private SimpleStringProperty name;

    public ProjectEditor(String surname,
                         String name)
    {
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
    }

    public String getSurname()
    {
        return this.surname.get();
    }

    public SimpleStringProperty surnameProperty()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname.set(surname);
    }

    public String getName()
    {
        return this.name.get();
    }

    public SimpleStringProperty nameProperty()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public String toString()
    {
        return "Name: " + this.surname + "Vorname: " + this.name;
    }
}
