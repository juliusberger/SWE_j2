package app.models.interfaces.Requirements;

import app.models.interfaces.I_XMLExportable;
import app.models.interfaces.I_XMLImportable;
import javafx.collections.ObservableList;
import app.models.interfaces.I_ModelEntryFactory;
import app.models.interfaces.I_ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_FunctionalRequirements extends I_ModelEntryFactory<I_FunctionalRequirementEntry>, I_ObservableDataAdaptor<I_FunctionalRequirementEntry>, I_XMLExportable, I_XMLImportable {
    ObservableList<I_FunctionalRequirementEntry> getEntries();
}
