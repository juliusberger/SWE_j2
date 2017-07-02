package app.model.interfaces.ProjectData;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für Daten des Projektbearbeiters
 */
public interface I_ProjectEditor extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getSurname();

    void setSurname(String surname);

    SimpleStringProperty surnameProperty();

    String getName();

    void setName(String name);

    SimpleStringProperty nameProperty();
}
