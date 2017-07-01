package app.model.implementation.ProjectData;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.ProjectData.I_Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_Customer}
 */
class Customer implements I_Customer {
    private final SimpleStringProperty _surname = new SimpleStringProperty("");
    private final SimpleStringProperty _name = new SimpleStringProperty("");
    private final SimpleStringProperty _telephone = new SimpleStringProperty("");
    private final SimpleStringProperty _email = new SimpleStringProperty("");

    private final SimpleStringProperty _companyName = new SimpleStringProperty("");
    private final SimpleStringProperty _companyStreet = new SimpleStringProperty("");
    private final SimpleStringProperty _companyPLZ = new SimpleStringProperty("");
    private final SimpleStringProperty _companyLocation = new SimpleStringProperty("");

    @Override
    public String getSurname() {
        return _surname.get();
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return _surname;
    }

    public void setSurname(String surname) {
        _surname.set(surname);
    }

    @Override
    public String getName() {
        return _name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return _name;
    }

    public void setName(String name) {
        _name.set(name);
    }

    @Override
    public String getTelephone() {
        return _telephone.get();
    }

    @Override
    public SimpleStringProperty telephoneProperty() {
        return _telephone;
    }

    public void setTelephone(String telephone) {
        _telephone.set(telephone);
    }

    @Override
    public String getEmail() {
        return _email.get();
    }

    @Override
    public SimpleStringProperty emailProperty() {
        return _email;
    }

    public void setEmail(String email) {
        _email.set(email);
    }

    @Override
    public String getCompanyName() {
        return _companyName.get();
    }

    @Override
    public SimpleStringProperty companyNameProperty() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        _companyName.set(companyName);
    }

    @Override
    public String getCompanyStreet() {
        return _companyStreet.get();
    }

    @Override
    public SimpleStringProperty companyStreetProperty() {
        return _companyStreet;
    }

    public void setCompanyStreet(String companyStreet) {
        _companyStreet.set(companyStreet);
    }

    @Override
    public String getCompanyPLZ() {
        return _companyPLZ.get();
    }

    @Override
    public SimpleStringProperty companyPLZProperty() {
        return _companyPLZ;
    }

    public void setCompanyPLZ(String companyPLZ) {
        _companyPLZ.set(companyPLZ);
    }

    @Override
    public String getCompanyLocation() {
        return _companyLocation.get();
    }

    @Override
    public SimpleStringProperty companyLocationProperty() {
        return _companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        _companyLocation.set(companyLocation);
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "Customer";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setSurname(propertyStrings.get(0));
            setName(propertyStrings.get(1));
            setTelephone(propertyStrings.get(2));
            setEmail(propertyStrings.get(3));

            setCompanyName(propertyStrings.get(4));
            setCompanyStreet(propertyStrings.get(5));
            setCompanyPLZ(propertyStrings.get(6));
            setCompanyLocation(propertyStrings.get(7));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getSurname());
        stringProperties.add(getName());
        stringProperties.add(getTelephone());
        stringProperties.add(getEmail());

        stringProperties.add(getCompanyName());
        stringProperties.add(getCompanyStreet());
        stringProperties.add(getCompanyPLZ());
        stringProperties.add(getCompanyLocation());

        return stringProperties;
    }


    @Override
    public void removeExistingData() {
        setSurname("");
        setName("");
        setTelephone("");
        setEmail("");
        setCompanyName("");
        setCompanyStreet("");
        setCompanyPLZ("");
        setCompanyLocation("");
    }
}
