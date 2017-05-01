package models.interfaces;

import javafx.beans.property.SimpleStringProperty;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.CostEstimation.I_CostEstimation;
import models.interfaces.Glossary.I_Glossary;
import models.interfaces.ProjectData.I_ProjectData;
import models.interfaces.Requirements.I_Requirements;

/**
 * Erstellt von Julius am 30/04/2017.
 */
public interface I_Project extends I_ModelPropertyAdaptor {
    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);

    String getFileLocation();

    SimpleStringProperty fileLocationProperty();

    void setFileLocation(String fileLocation);

    I_ProjectData getProjectData();

    I_Analysis getStateAnalysis();

    I_Analysis getFutureAnalysis();

    I_CostEstimation getCostEstimation();

    I_Requirements getRequirements();

    I_Glossary getGlossary();
}
