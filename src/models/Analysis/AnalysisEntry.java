package models.Analysis;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class AnalysisEntry {
    private final SimpleStringProperty entryName;
    private final SimpleStringProperty description;

    AnalysisEntry(String entryName,
                  String description) {
        this.entryName = new SimpleStringProperty(entryName);
        this.description = new SimpleStringProperty(description);
    }


    String getEntryName() {
        return this.entryName.get();
    }

    public SimpleStringProperty entryNameProperty() {
        return this.entryName;
    }

    void setEntryName(String entryName) {
        this.entryName.set(entryName);
    }

    String getDescription() {
        return this.description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    void setDescription(String description) {
        this.description.set(description);
    }

    public String toString() {
        return "Name: " + this.getEntryName() + "\nDescription: " + this.getDescription();
    }
}
