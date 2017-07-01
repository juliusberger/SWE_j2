package app.model.interfaces.CostEstimation;

import app.model.interfaces.*;
import javafx.collections.ObservableList;

/**
 * Model der Klassifikation. Gedacht für Halterklassen von {@link I_ClassificationEntry}.
 */
public interface I_Classification extends I_ModelEntryFactory<I_ClassificationEntry>, I_ObservableDataAdaptor<I_ClassificationEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_ClassificationEntry> getEntries();
}
