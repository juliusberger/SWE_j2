package app.model.interfaces.ProjectData;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für Kundendaten.
 */
public interface I_Customer extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getSurname();

    void setSurname(String surname);

    SimpleStringProperty surnameProperty();

    String getName();

    void setName(String name);

    SimpleStringProperty nameProperty();

    String getTelephone();

    void setTelephone(String telephone);

    SimpleStringProperty telephoneProperty();

    String getEmail();

    void setEmail(String email);

    SimpleStringProperty emailProperty();

    String getCompanyName();

    void setCompanyName(String companyName);

    SimpleStringProperty companyNameProperty();

    String getCompanyStreet();

    void setCompanyStreet(String companyStreet);

    SimpleStringProperty companyStreetProperty();

    String getCompanyPLZ();

    void setCompanyPLZ(String companyPLZ);

    SimpleStringProperty companyPLZProperty();

    String getCompanyLocation();

    void setCompanyLocation(String companyLocation);

    SimpleStringProperty companyLocationProperty();
}
