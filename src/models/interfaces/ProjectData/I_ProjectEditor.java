package models.interfaces.ProjectData;

import javafx.beans.property.SimpleStringProperty;
import models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectEditor extends I_ModelPropertyAdaptor {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);
}
