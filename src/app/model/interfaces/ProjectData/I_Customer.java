package app.model.interfaces.ProjectData;

import app.model.interfaces.*;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für Kundendaten.
 */
public interface I_Customer extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
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
