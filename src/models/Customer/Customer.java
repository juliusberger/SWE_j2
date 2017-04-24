package models.Customer;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Customer
{
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

    public String getSurname()
    {
        return this.surname.get();
    }

    public SimpleStringProperty surnameProperty()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname.set(surname);
    }

    public String getName()
    {
        return this.name.get();
    }

    public SimpleStringProperty nameProperty()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public String getTelephone()
    {
        return this.telephone.get();
    }

    public SimpleStringProperty telephoneProperty()
    {
        return this.telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone.set(telephone);
    }

    public String getEmail()
    {
        return this.email.get();
    }

    public SimpleStringProperty emailProperty()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email.set(email);
    }

    public String getCompanyName()
    {
        return this.companyName.get();
    }

    public SimpleStringProperty companyNameProperty()
    {
        return this.companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName.set(companyName);
    }

    public String getCompanyStreet()
    {
        return this.companyStreet.get();
    }

    public SimpleStringProperty companyStreetProperty()
    {
        return this.companyStreet;
    }

    public void setCompanyStreet(String companyStreet)
    {
        this.companyStreet.set(companyStreet);
    }

    public String getCompanyPLZ()
    {
        return this.companyPLZ.get();
    }

    public SimpleStringProperty companyPLZProperty()
    {
        return this.companyPLZ;
    }

    public void setCompanyPLZ(String companyPLZ)
    {
        this.companyPLZ.set(companyPLZ);
    }

    public String getCompanyLocation()
    {
        return this.companyLocation.get();
    }

    public SimpleStringProperty companyLocationProperty()
    {
        return this.companyLocation;
    }

    public void setCompanyLocation(String companyLocation)
    {
        this.companyLocation.set(companyLocation);
    }
}
