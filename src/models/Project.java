package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Project
{
    private final SimpleStringProperty name;
    private final SimpleStringProperty dateCreated;
    private final SimpleStringProperty dateModified;
    private final SimpleStringProperty fileLocation;

    private ProjectData projectData;

    public Project(String name,
                   String dateCreated,
                   String dateModified,
                   String fileLocation,
                   ProjectData projectData)
    {

        this.name = new SimpleStringProperty(name);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.dateModified = new SimpleStringProperty(dateModified);
        this.fileLocation = new SimpleStringProperty(fileLocation);

        this.projectData = projectData;
    }

    public String getName()
    {
        return name.get();
    }

    public SimpleStringProperty nameProperty()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    public String getDateCreated()
    {
        return dateCreated.get();
    }

    public SimpleStringProperty dateCreatedProperty()
    {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated)
    {
        this.dateCreated.set(dateCreated);
    }

    public String getDateModified()
    {
        return dateModified.get();
    }

    public SimpleStringProperty dateModifiedProperty()
    {
        return dateModified;
    }

    public void setDateModified(String dateModified)
    {
        this.dateModified.set(dateModified);
    }
}
