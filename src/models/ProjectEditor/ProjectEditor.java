package models.ProjectEditor;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class ProjectEditor implements I_ProjectEditor {
    private SimpleStringProperty surname;
    private SimpleStringProperty name;

    public ProjectEditor(String surname,
                         String name)
    {
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
    }

    @Override
    public String getSurname() {
        return this.surname.get();
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return this.surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname.set(surname);
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

    public String toString()
    {
        return "Name: " + this.surname + "Vorname: " + this.name;
    }
}
