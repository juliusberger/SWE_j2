package app.models.interfaces.ProjectData;

import app.models.interfaces.I_Removable;
import app.models.interfaces.I_XMLExportable;
import app.models.interfaces.I_XMLImportable;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Customer extends I_ModelPropertyAdaptor, I_XMLExportable, I_XMLImportable, I_Removable {
    String getSurname();

    SimpleStringProperty surnameProperty();

    void setSurname(String surname);

    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);

    String getTelephone();

    SimpleStringProperty telephoneProperty();

    void setTelephone(String telephone);

    String getEmail();

    SimpleStringProperty emailProperty();

    void setEmail(String email);

    String getCompanyName();

    SimpleStringProperty companyNameProperty();

    void setCompanyName(String companyName);

    String getCompanyStreet();

    SimpleStringProperty companyStreetProperty();

    void setCompanyStreet(String companyStreet);

    String getCompanyPLZ();

    SimpleStringProperty companyPLZProperty();

    void setCompanyPLZ(String companyPLZ);

    String getCompanyLocation();

    SimpleStringProperty companyLocationProperty();

    void setCompanyLocation(String companyLocation);
}
