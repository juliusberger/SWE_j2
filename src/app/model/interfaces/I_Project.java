package app.model.interfaces;

import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_CostEstimation;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.ProjectData.I_ProjectData;
import app.model.interfaces.Requirements.I_Requirements;

/**
 * Repräsentiert das root Model Projekt mit allen enthaltenen Model-Komponenten.
 */
public interface I_Project extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    I_ProjectData getProjectData();

    I_Analysis getStateAnalysis();

    I_Analysis getFutureAnalysis();

    I_CostEstimation getCostEstimation();

    I_Classification getClassification();

    I_Requirements getRequirements();

    I_Glossary getGlossary();
}
