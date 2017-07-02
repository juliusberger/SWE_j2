package app.model.interfaces.ProjectData;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für Projektdaten.
 */
public interface I_ProjectData extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getName();

    void setName(String name);

    SimpleStringProperty nameProperty();

    String getDueDate();

    void setDueDate(String dueDate);

    SimpleStringProperty dueDateProperty();

    I_ProjectEditor getProjectEditor();

    I_Customer getCustomer();
}
