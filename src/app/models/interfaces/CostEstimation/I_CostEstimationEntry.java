package app.models.interfaces.CostEstimation;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public interface I_CostEstimationEntry {
    String getWeight();

    void setWeight(String weight);

    SimpleStringProperty getWeightProperty();
}
