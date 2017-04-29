package models.Analysis;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_AnalysisEntry {
    String getEntryName();

    SimpleStringProperty entryNameProperty();

    void setEntryName(String entryName);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
