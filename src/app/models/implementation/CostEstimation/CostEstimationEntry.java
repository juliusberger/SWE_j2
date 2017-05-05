package app.models.implementation.CostEstimation;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.CostEstimation.I_CostEstimationEntry;

/**
 * Erstellt von Julius am 01/05/2017.
 */
class CostEstimationEntry implements I_CostEstimationEntry {
    private SimpleStringProperty _weight = new SimpleStringProperty("");

    @Override
    public String getWeight() {
        return this._weight.get();
    }

    @Override
    public void setWeight(String weight) {
        this._weight.set(weight);
    }

    @Override
    public SimpleStringProperty getWeightProperty() {
        return this._weight;
    }
}
