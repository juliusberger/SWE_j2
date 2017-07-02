package app.model.interfaces.Requirements;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelEntryFactory;
import app.model.interfaces.I_ObservableDataAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.collections.ObservableList;

/**
 * Model der funktionalen Anforderungen. Gedacht für Halterklassen von {@link I_FunctionalRequirementEntry}.
 */
public interface I_FunctionalRequirements extends I_ModelEntryFactory<I_FunctionalRequirementEntry>, I_ObservableDataAdaptor<I_FunctionalRequirementEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_FunctionalRequirementEntry> getEntries();
}
