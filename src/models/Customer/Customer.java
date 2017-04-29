package models.Customer;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Customer implements I_Customer {
    private final SimpleStringProperty surname;
    private final SimpleStringProperty name;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty email;

    private final SimpleStringProperty companyName;
    private final SimpleStringProperty companyStreet;
    private final SimpleStringProperty companyPLZ;
    private final SimpleStringProperty companyLocation;

    public Customer(String surname,
                    String name,
                    String telephone,
                    String email,
                    String companyName,
                    String companyStreet,
                    String companyPLZ,
                    String companyLocation)
    {
        this.surname = new SimpleStringProperty(surname);
        this.name = new SimpleStringProperty(name);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);

        this.companyName = new SimpleStringProperty(companyName);
        this.companyStreet = new SimpleStringProperty(companyStreet);
        this.companyPLZ = new SimpleStringProperty(companyPLZ);
        this.companyLocation = new SimpleStringProperty(companyLocation);
    }

    @Override
    public String getSurname() {
        return this.surname.get();
    }

    @Override
    public SimpleStringProperty surnameProperty() {
        return this.surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    @Override
    public String getName() {
        return this.name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String getTelephone() {
        return this.telephone.get();
    }

    @Override
    public SimpleStringProperty telephoneProperty() {
        return this.telephone;
    }

    @Override
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    @Override
    public String getEmail() {
        return this.email.get();
    }

    @Override
    public SimpleStringProperty emailProperty() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public String getCompanyName() {
        return this.companyName.get();
    }

    @Override
    public SimpleStringProperty companyNameProperty() {
        return this.companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    @Override
    public String getCompanyStreet() {
        return this.companyStreet.get();
    }

    @Override
    public SimpleStringProperty companyStreetProperty() {
        return this.companyStreet;
    }

    @Override
    public void setCompanyStreet(String companyStreet) {
        this.companyStreet.set(companyStreet);
    }

    @Override
    public String getCompanyPLZ() {
        return this.companyPLZ.get();
    }

    @Override
    public SimpleStringProperty companyPLZProperty() {
        return this.companyPLZ;
    }

    @Override
    public void setCompanyPLZ(String companyPLZ) {
        this.companyPLZ.set(companyPLZ);
    }

    @Override
    public String getCompanyLocation() {
        return this.companyLocation.get();
    }

    @Override
    public SimpleStringProperty companyLocationProperty() {
        return this.companyLocation;
    }

    @Override
    public void setCompanyLocation(String companyLocation) {
        this.companyLocation.set(companyLocation);
    }
}
