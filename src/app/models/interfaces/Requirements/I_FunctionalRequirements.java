package app.models.interfaces.Requirements;

import app.models.interfaces.*;
import javafx.collections.ObservableList;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_FunctionalRequirements extends I_ModelEntryFactory<I_FunctionalRequirementEntry>, I_ObservableDataAdaptor<I_FunctionalRequirementEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_FunctionalRequirementEntry> getEntries();
}
