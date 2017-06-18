package app.models.interfaces;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.Analysis.I_Analysis;
import app.models.interfaces.CostEstimation.I_CostEstimation;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.ProjectData.I_ProjectData;
import app.models.interfaces.Requirements.I_Requirements;

/**
 * Erstellt von Julius am 30/04/2017.
 */
public interface I_Project extends I_ModelPropertyAdaptor, I_XmlModelEntity {

    I_ProjectData getProjectData();

    I_Analysis getStateAnalysis();

    I_Analysis getFutureAnalysis();

    I_CostEstimation getCostEstimation();

    I_Requirements getRequirements();

    I_Glossary getGlossary();
}
