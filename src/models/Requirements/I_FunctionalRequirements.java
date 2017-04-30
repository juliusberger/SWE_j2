package models.Requirements;

import javafx.collections.ObservableList;
import models.I_ModelEntryFactory;
import models.I_ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_FunctionalRequirements extends I_ModelEntryFactory<I_FunctionalRequirementEntry>, I_ObservableDataAdaptor<I_FunctionalRequirementEntry> {
    ObservableList<I_FunctionalRequirementEntry> getEntries();
}
