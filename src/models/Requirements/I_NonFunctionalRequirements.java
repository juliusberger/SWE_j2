package models.Requirements;

import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_NonFunctionalRequirements extends ObservableDataAdaptor<I_NonFunctionalRequirementEntry> {
    ObservableList<I_NonFunctionalRequirementEntry> getEntries();
}
