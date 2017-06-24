package app.model.interfaces.CostEstimation;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;

import java.util.List;

/**
 * Erstellt von Julius am 01/05/2017.
 */
public interface I_CostEstimation extends I_ModelPropertyAdaptor, I_XmlModelEntity, I_Clearable {
    List<I_CostEstimationEntry> getCostEstimationEntries();

    I_Classification getClassification();
}
