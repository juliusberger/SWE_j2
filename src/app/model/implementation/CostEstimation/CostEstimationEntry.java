package app.model.implementation.CostEstimation;

import app.model.interfaces.CostEstimation.I_CostEstimationEntry;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_CostEstimationEntry}
 */
class CostEstimationEntry implements I_CostEstimationEntry {
    private final SimpleStringProperty _weight = new SimpleStringProperty("");

    @Override
    public String getWeight() {
        return _weight.get();
    }

    @Override
    public void setWeight(String weight) {
        _weight.set(weight);
    }

    @Override
    public SimpleStringProperty getWeightProperty() {
        return _weight;
    }


    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "CostEstimationEntry";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getWeight());

        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setWeight(propertyStrings.get(0));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }


}
