package app.model.interfaces.CostEstimation;

import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle der Klassifizierung.
 */
public interface I_ClassificationEntry extends I_CostEstimationEntry {
    String getFunction();

    void setFunction(String function);

    SimpleStringProperty functionProperty();

    String getDescription();

    void setDescription(String description);

    SimpleStringProperty descriptionProperty();

    String getStakeholder();

    void setStakeholder(String stakeholder);

    SimpleStringProperty stakeholderProperty();

    String getCategory();

    void setCategory(String category);

    SimpleStringProperty categoryProperty();

    String getClassification();

    void setClassification(String classification);

    SimpleStringProperty classificationProperty();
}
