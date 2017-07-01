package app.model.interfaces.ProjectData;

import app.model.interfaces.*;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für Daten des Projektbearbeiters
 */
public interface I_ProjectEditor extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);
}
