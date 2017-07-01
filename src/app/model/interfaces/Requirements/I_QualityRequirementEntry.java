package app.model.interfaces.Requirements;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Model für einen Eintrag für die Auflistung der Qualitätsanforderungen.
 */
public interface I_QualityRequirementEntry extends I_XmlModelEntity, I_Clearable {
    SimpleObjectProperty<Priority> priorityProperty();

    Priority getPriority();

    void setPriority(Priority priority);

    enum Priority {
        HIGH, MEDIUM, LOW, IRRELEVANT, UNSET
    }
}
