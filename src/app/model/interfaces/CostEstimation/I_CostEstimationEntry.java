package app.model.interfaces.CostEstimation;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public interface I_CostEstimationEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getWeight();

    void setWeight(String weight);

    SimpleStringProperty getWeightProperty();

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
