package app.model.interfaces.Requirements;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Gemeinsames Interface der {@link I_FunctionalRequirementEntry} und {@link I_NonFunctionalRequirementEntry}.
 */
public interface I_RequirementEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getDescription();

    void setDescription(String description);

    SimpleStringProperty descriptionProperty();
}
