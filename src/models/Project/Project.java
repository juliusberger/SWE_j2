package models.Project;

import javafx.beans.property.SimpleStringProperty;
import models.ProjectData.ProjectData;

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

    public String getDateCreated()
    {
        return this.dateCreated.get();
    }

    public SimpleStringProperty dateCreatedProperty()
    {
        return this.dateCreated;
    }

    public void setDateCreated(String dateCreated)
    {
        this.dateCreated.set(dateCreated);
    }

    public String getDateModified()
    {
        return this.dateModified.get();
    }

    public SimpleStringProperty dateModifiedProperty()
    {
        return this.dateModified;
    }

    public void setDateModified(String dateModified)
    {
        this.dateModified.set(dateModified);
    }
}
