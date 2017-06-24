package app.model.interfaces.CostEstimation;

import app.model.interfaces.*;
import javafx.collections.ObservableList;

/**
 * Created by Matthias on 24.06.2017.
 */
public interface I_Classification extends I_ModelEntryFactory<I_ClassificationEntry>, I_ObservableDataAdaptor<I_ClassificationEntry>, I_XmlModelEntity, I_Clearable {
    ObservableList<I_ClassificationEntry> getEntries();
}
