package app.model.interfaces.Analysis;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabellen der Ist- und Soll-Analyse.
 */
public interface I_AnalysisEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getEntryName();

    void setEntryName(String entryName);

    SimpleStringProperty entryNameProperty();

    String getDescription();

    void setDescription(String description);

    SimpleStringProperty descriptionProperty();
}
