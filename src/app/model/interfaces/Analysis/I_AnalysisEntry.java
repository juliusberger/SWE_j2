package app.model.interfaces.Analysis;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabellen der Ist- und Soll-Analyse.
 */
public interface I_AnalysisEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getEntryName();

    SimpleStringProperty entryNameProperty();

    void setEntryName(String entryName);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
