package app.model.interfaces.Requirements;

import app.model.interfaces.*;
import javafx.collections.ObservableList;

/**
 * Model der nicht-funktionalen Anforderungen. Gedacht für Halterklassen von {@link I_NonFunctionalRequirementEntry}.
 */
public interface I_NonFunctionalRequirements extends I_ModelEntryFactory<I_NonFunctionalRequirementEntry>, I_ObservableDataAdaptor<I_NonFunctionalRequirementEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_NonFunctionalRequirementEntry> getEntries();
}
