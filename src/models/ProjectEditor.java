package models;

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
        return surname.get();
    }

    public SimpleStringProperty surnameProperty()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname.set(surname);
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

    public String toString()
    {
        return "Name: " + surname + "Vorname: " + name;
    }
}
