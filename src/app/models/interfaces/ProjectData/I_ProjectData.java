package app.models.interfaces.ProjectData;

import app.models.interfaces.I_XmlExportable;
import app.models.interfaces.I_XmlImportable;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectData extends I_ModelPropertyAdaptor, I_XmlExportable, I_XmlImportable {
    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);

    String getDueDate();

    SimpleStringProperty dueDateProperty();

    void setDueDate(String dueDate);

    I_ProjectEditor getProjectEditor();

    I_Customer getCustomer();
}
