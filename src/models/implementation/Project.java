package models.implementation;

import javafx.beans.property.SimpleStringProperty;
import models.implementation.Analysis.FutureAnalysis;
import models.implementation.Analysis.StateAnalysis;
import models.implementation.Glossary.Glossary;
import models.implementation.ProjectData.ProjectData;
import models.implementation.Requirements.Requirements;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.I_Project;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.Requirements.I_Requirements;

import java.util.ArrayList;

/**
 *
 */
public class Project implements I_Project {
    private static I_Project _instance;

    public static I_Project getInstance() {
        if (Project._instance == null)
            Project._instance = new Project();
        return Project._instance;
    }


    private final SimpleStringProperty _name = new SimpleStringProperty("");
    private final SimpleStringProperty _fileLocation = new SimpleStringProperty("");

    private I_ProjectData _projectData = new ProjectData();
    private I_Analysis _stateAnalysis = new StateAnalysis();
    private I_Analysis _futureAnalysis = new FutureAnalysis();
    private I_Requirements _requirements = new Requirements();
    /*private CostEstimation _costEstimation;*/
    private I_Glossary _glossary = new Glossary();


    private Project() {
    }


    @Override
    public String getName() {
        return this._name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return this._name;
    }

    @Override
    public void setName(String name) {
        this._name.set(name);
    }

    @Override
    public String getFileLocation() {
        return this._fileLocation.get();
    }

    @Override
    public SimpleStringProperty fileLocationProperty() {
        return this._fileLocation;
    }

    @Override
    public void setFileLocation(String fileLocation) {
        this._fileLocation.set(fileLocation);
    }

    @Override
    public I_ProjectData getProjectData() {
        return this._projectData;
    }

    @Override
    public I_Analysis getStateAnalysis() {
        return this._stateAnalysis;
    }

    @Override
    public I_Analysis getFutureAnalysis() {
        return this._futureAnalysis;
    }

    @Override
    public I_Requirements getRequirements() {
        return this._requirements;
    }

    @Override
    public I_Glossary getGlossary() {
        return this._glossary;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        this.setName(propertyStrings.get(0));
        this.setFileLocation(propertyStrings.get(1));
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getName());
        stringProperties.add(this.getFileLocation());

        return stringProperties;
    }
}
