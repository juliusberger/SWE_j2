package models;

import javafx.beans.property.SimpleStringProperty;
import models.Analysis.I_Analysis;
import models.Glossary.I_Glossary;
import models.ProjectData.I_ProjectData;
import models.Requirements.I_Requirements;

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

    I_Requirements getRequirements();

    I_Glossary getGlossary();
}
