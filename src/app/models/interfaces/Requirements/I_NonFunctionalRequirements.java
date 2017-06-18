package app.models.interfaces.Requirements;

import app.models.interfaces.*;
import javafx.collections.ObservableList;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_NonFunctionalRequirements extends I_ModelEntryFactory<I_NonFunctionalRequirementEntry>, I_ObservableDataAdaptor<I_NonFunctionalRequirementEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_NonFunctionalRequirementEntry> getEntries();
}
