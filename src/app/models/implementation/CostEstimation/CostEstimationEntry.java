package app.models.implementation.CostEstimation;

import app.models.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.CostEstimation.I_CostEstimationEntry;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return null;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }
}
