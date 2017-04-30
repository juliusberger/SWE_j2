package models.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;
import models.interfaces.I_ModelPropertyAdaptor;

import java.util.List;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Requirements extends I_ModelPropertyAdaptor {
    String getProjectGoal();

    SimpleStringProperty projectGoalProperty();

    void setProjectGoal(String projectGoal);

    String getFieldOfApplication();

    SimpleStringProperty fieldOfApplicationProperty();

    void setFieldOfApplication(String fieldOfApplication);

    I_FunctionalRequirements getFunctionalRequirements();

    I_NonFunctionalRequirements getNonFunctionalRequirements();

    List<I_QualityRequirementEntry> getQualityRequirementEntries();

    I_Comments getComments();
}
