package models.Analysis;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class AnalysisEntry {
    private final SimpleStringProperty entryName;
    private final SimpleStringProperty description;

    public AnalysisEntry(String entryName,
                         String description) {
        this.entryName = new SimpleStringProperty(entryName);
        this.description = new SimpleStringProperty(description);
    }

    public String getEntryName() {
        return entryName.get();
    }

    public SimpleStringProperty entryNameProperty() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName.set(entryName);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String toString() {
        return "Name: " + getEntryName() + "\nDescription: " + getDescription();
    }
}
