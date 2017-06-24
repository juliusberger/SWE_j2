package app.model.interfaces.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public interface I_RequirementEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
