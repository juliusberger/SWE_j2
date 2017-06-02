package app.models.interfaces.CostEstimation;

import app.models.interfaces.I_XmlExportable;
import app.models.interfaces.I_XmlImportable;

import java.util.List;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public interface I_CostEstimation extends I_XmlExportable, I_XmlImportable {
    List<I_CostEstimationEntry> getCostEstimationEntries();
}
