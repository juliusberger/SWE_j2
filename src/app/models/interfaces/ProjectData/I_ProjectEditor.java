package app.models.interfaces.ProjectData;

import app.models.interfaces.I_XMLExportable;
import app.models.interfaces.I_XMLImportable;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectEditor extends I_ModelPropertyAdaptor, I_XMLExportable, I_XMLImportable {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);
}
