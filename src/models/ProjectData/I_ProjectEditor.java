package models.ProjectData;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectEditor {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);
}
