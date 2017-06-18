package app.models.interfaces.ProjectData;

import app.models.interfaces.*;
import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectEditor extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);
}
