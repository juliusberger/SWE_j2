package app.model.interfaces.CostEstimation;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Matthias on 24.06.2017.
 */
public interface I_ClassificationEntry extends I_CostEstimationEntry {
    String getFunction();

    SimpleStringProperty functionProperty();

    void setFunction(String function);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);

    String getStakeholder();

    SimpleStringProperty stakeholderProperty();

    void setStakeholder(String stakeholder);

    String getCategory();

    SimpleStringProperty categoryProperty();

    void setCategory(String category);

    String getClassification();

    SimpleStringProperty classificationProperty();

    void setClassification(String classification);
}
