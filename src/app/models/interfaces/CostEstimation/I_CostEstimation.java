package app.models.interfaces.CostEstimation;

import app.models.interfaces.I_XMLExportable;
import app.models.interfaces.I_XMLImportable;

import java.util.List;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public interface I_CostEstimation extends I_XMLExportable, I_XMLImportable {
    List<I_CostEstimationEntry> getCostEstimationEntries();
}
