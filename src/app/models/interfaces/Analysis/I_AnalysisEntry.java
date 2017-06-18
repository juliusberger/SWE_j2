package app.models.interfaces.Analysis;

import app.models.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_AnalysisEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getEntryName();

    SimpleStringProperty entryNameProperty();

    void setEntryName(String entryName);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
