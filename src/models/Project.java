package models;

import javafx.beans.property.SimpleStringProperty;
import models.Analysis.FutureAnalysis;
import models.Analysis.I_Analysis;
import models.Analysis.StateAnalysis;
import models.Glossary.Glossary;
import models.Glossary.I_Glossary;
import models.ProjectData.I_ProjectData;
import models.ProjectData.ProjectData;
import models.Requirements.I_Requirements;
import models.Requirements.Requirements;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Project {
    private static Project _instance;

    private final SimpleStringProperty _name = new SimpleStringProperty();
    private final SimpleStringProperty _dateCreated = new SimpleStringProperty();
    private final SimpleStringProperty _dateModified = new SimpleStringProperty();
    private final SimpleStringProperty _fileLocation = new SimpleStringProperty();

    private I_ProjectData _projectData = new ProjectData();
    private I_Analysis _stateAnalysis = new StateAnalysis();
    private I_Analysis _futureAnalysis = new FutureAnalysis();
    private I_Requirements _requirements = new Requirements();
    /*private CostEstimation _costEstimation;*/
    private I_Glossary _glossary = new Glossary();

    private Project() {
    }

    public static Project getInstance() {
        if (Project._instance == null)
            Project._instance = new Project();
        return Project._instance;
    }


    public String getName() {
        return this._name.get();
    }

    public SimpleStringProperty nameProperty() {
        return this._name;
    }

    public void setName(String name) {
        this._name.set(name);
    }

    public String getDateCreated() {
        return this._dateCreated.get();
    }

    public SimpleStringProperty dateCreatedProperty() {
        return this._dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this._dateCreated.set(dateCreated);
    }

    public String getDateModified() {
        return this._dateModified.get();
    }

    public SimpleStringProperty dateModifiedProperty() {
        return this._dateModified;
    }

    public void setDateModified(String dateModified) {
        this._dateModified.set(dateModified);
    }

    public String getFileLocation() {
        return this._fileLocation.get();
    }

    public SimpleStringProperty fileLocationProperty() {
        return this._fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this._fileLocation.set(fileLocation);
    }

    public I_ProjectData getProjectData() {
        return this._projectData;
    }

    public I_Analysis getStateAnalysis() {
        return this._stateAnalysis;
    }

    public I_Analysis getFutureAnalysis() {
        return this._futureAnalysis;
    }

    public I_Requirements getRequirements() {
        return this._requirements;
    }

    public I_Glossary getGlossary() {
        return this._glossary;
    }
}
