package models.Requirements;

import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_FunctionalRequirements extends ObservableDataAdaptor<I_FunctionalRequirementEntry> {
    ObservableList<I_FunctionalRequirementEntry> getEntries();
}
