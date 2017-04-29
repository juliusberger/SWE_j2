package models.Project;

import javafx.beans.property.SimpleStringProperty;
import models.Analysis.I_Analysis;
import models.Glossary.I_Glossary;
import models.ProjectData.I_ProjectData;
import models.Requirements.I_Requirements;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Project
{
    private final SimpleStringProperty name;
    private final SimpleStringProperty dateCreated;
    private final SimpleStringProperty dateModified;
    private final SimpleStringProperty fileLocation;

    private I_ProjectData IProjectData;
    private I_Analysis stateAnalysis;
    private I_Analysis futureAnalysis;
    private I_Requirements IRequirements;
    /*private CostEstimation costEstimation;*/
    private I_Glossary IGlossary;

    public Project(String name,
                   String dateCreated,
                   String dateModified,
                   String fileLocation,
                   I_ProjectData IProjectData)
    {

        this.name = new SimpleStringProperty(name);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.dateModified = new SimpleStringProperty(dateModified);
        this.fileLocation = new SimpleStringProperty(fileLocation);

        this.IProjectData = IProjectData;
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
