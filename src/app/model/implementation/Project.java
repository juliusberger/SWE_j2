package app.model.implementation;

import app.model.implementation.CostEstimation.Classification;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.I_XmlModelEntity;
import app.model.implementation.Analysis.FutureAnalysis;
import app.model.implementation.Analysis.StateAnalysis;
import app.model.implementation.CostEstimation.CostEstimation;
import app.model.implementation.Glossary.Glossary;
import app.model.implementation.ProjectData.ProjectData;
import app.model.implementation.Requirements.Requirements;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.CostEstimation.I_CostEstimation;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.I_Project;
import app.model.interfaces.ProjectData.I_ProjectData;
import app.model.interfaces.Requirements.I_Requirements;

import java.util.ArrayList;
import java.util.List;

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

    private I_ProjectData _projectData = new ProjectData();
    private I_Analysis _stateAnalysis = new StateAnalysis();
    private I_Analysis _futureAnalysis = new FutureAnalysis();
    private I_Requirements _requirements = new Requirements();
    private I_CostEstimation _costEstimation = new CostEstimation();
    private I_Classification _classification = new Classification();
    private I_Glossary _glossary = new Glossary();


    private Project() {
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
    public I_CostEstimation getCostEstimation() {
        return this._costEstimation;
    }

    @Override
    public I_Classification getClassification() {
        return this._classification;
    }

    @Override
    public I_Glossary getGlossary() {
        return this._glossary;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        List<I_XmlModelEntity> children = new ArrayList<>(6);
        children.add(this.getProjectData());
        children.add(this.getStateAnalysis());
        children.add(this.getFutureAnalysis());
        children.add(this.getRequirements());
        /*children.add(this.getCostEstimation());*/
        children.add(this.getGlossary());
        return children;
    }

    @Override
    public String getTag() {
        return "Project";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

}
