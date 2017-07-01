package app.model.implementation;

import app.model.implementation.Analysis.FutureAnalysis;
import app.model.implementation.Analysis.StateAnalysis;
import app.model.implementation.CostEstimation.Classification;
import app.model.implementation.CostEstimation.CostEstimation;
import app.model.implementation.Glossary.Glossary;
import app.model.implementation.ProjectData.ProjectData;
import app.model.implementation.Requirements.Requirements;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_CostEstimation;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.I_Project;
import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.ProjectData.I_ProjectData;
import app.model.interfaces.Requirements.I_Requirements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class Project implements I_Project {
    private static I_Project _instance;

    private final I_ProjectData _projectData = new ProjectData();
    private final I_Analysis _stateAnalysis = new StateAnalysis();
    private final I_Analysis _futureAnalysis = new FutureAnalysis();
    private final I_Requirements _requirements = new Requirements();
    private final I_CostEstimation _costEstimation = new CostEstimation();
    private final I_Classification _classification = new Classification();
    private final I_Glossary _glossary = new Glossary();

    private Project() {
    }

    public static I_Project getInstance() {
        if (_instance == null) _instance = new Project();
        return _instance;
    }

    @Override
    public I_ProjectData getProjectData() {
        return _projectData;
    }

    @Override
    public I_Analysis getStateAnalysis() {
        return _stateAnalysis;
    }

    @Override
    public I_Analysis getFutureAnalysis() {
        return _futureAnalysis;
    }

    @Override
    public I_Requirements getRequirements() {
        return _requirements;
    }

    @Override
    public I_CostEstimation getCostEstimation() {
        return _costEstimation;
    }

    @Override
    public I_Classification getClassification() {
        return _classification;
    }

    @Override
    public I_Glossary getGlossary() {
        return _glossary;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        List<I_XmlModelEntity> children = new ArrayList<>(6);
        children.add(getProjectData());
        children.add(getStateAnalysis());
        children.add(getFutureAnalysis());
        children.add(getRequirements());
        children.add(getCostEstimation());
        children.add(getClassification());
        children.add(getGlossary());
        return children;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {
    }

    @Override
    public String getTag() {
        return "Project";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
    }

    @Override
    public void removeExistingData() {
        getProjectData().removeExistingData();
        getStateAnalysis().removeExistingData();
        getFutureAnalysis().removeExistingData();
        getRequirements().removeExistingData();
        getCostEstimation().removeExistingData();
        getClassification().removeExistingData();
        getGlossary().removeExistingData();
    }
}
