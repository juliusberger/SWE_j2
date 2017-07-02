package app.model.interfaces.Requirements;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

/**
 * Model des Lastenhefts. Gedacht für Halterklassen von:
 * - {@link I_FunctionalRequirements}
 * - {@link I_NonFunctionalRequirements}
 * - {@link I_QualityRequirementEntry}
 * - {@link I_Comments}
 */
public interface I_Requirements extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    String getProjectGoal();

    void setProjectGoal(String projectGoal);

    SimpleStringProperty projectGoalProperty();

    String getFieldOfApplication();

    void setFieldOfApplication(String fieldOfApplication);

    SimpleStringProperty fieldOfApplicationProperty();

    I_FunctionalRequirements getFunctionalRequirements();

    I_NonFunctionalRequirements getNonFunctionalRequirements();

    List<I_QualityRequirementEntry> getQualityRequirementEntries();

    I_Comments getComments();
}
