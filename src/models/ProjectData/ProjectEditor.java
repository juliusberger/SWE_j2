package models.ProjectData;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class ProjectEditor implements I_ProjectEditor {
    private final SimpleStringProperty _surname = new SimpleStringProperty();
    private final SimpleStringProperty _name = new SimpleStringProperty();

    ProjectEditor() {

    }

    @Override
    public String getSurname() {
        return this._surname.get();
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return this._surname;
    }

    @Override
    public void setSurname(String surname) {
        this._surname.set(surname);
    }

    @Override
    public String getName() {
        return this._name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return this._name;
    }

    @Override
    public void setName(String name) {
        this._name.set(name);
    }

    public String toString() {
        return "Name: " + this._surname + "Vorname: " + this._name;
    }
}
