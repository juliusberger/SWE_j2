package app.model.interfaces.CostEstimation;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Kostenschätzung.
 */
public interface I_CostEstimationEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getWeight();

    void setWeight(String weight);

    SimpleStringProperty getWeightProperty();
}
