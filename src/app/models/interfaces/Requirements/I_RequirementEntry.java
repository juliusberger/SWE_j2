package app.models.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public interface I_RequirementEntry extends I_ModelPropertyAdaptor {
    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
