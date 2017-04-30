package models.Requirements;

import javafx.collections.ObservableList;
import models.I_ModelEntryFactory;
import models.I_ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_NonFunctionalRequirements extends I_ModelEntryFactory<I_NonFunctionalRequirementEntry>, I_ObservableDataAdaptor<I_NonFunctionalRequirementEntry> {
    ObservableList<I_NonFunctionalRequirementEntry> getEntries();
}
