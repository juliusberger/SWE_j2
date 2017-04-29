package models.Analysis;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class AnalysisEntry implements I_AnalysisEntry {
    private final SimpleStringProperty entryName;
    private final SimpleStringProperty description;

    public AnalysisEntry() {
        this.entryName = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
    }

    public AnalysisEntry(String entryName,
                         String description) {
        this.entryName = new SimpleStringProperty(entryName);
        this.description = new SimpleStringProperty(description);
    }


    @Override
    public String getEntryName() {
        return this.entryName.get();
    }

    @Override
    public SimpleStringProperty entryNameProperty() {
        return this.entryName;
    }

    @Override
    public void setEntryName(String entryName) {
        this.entryName.set(entryName);
    }

    @Override
    public String getDescription() {
        return this.description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description.set(description);
    }

    public String toString() {
        return "Name: " + this.getEntryName() + "\nDescription: " + this.getDescription();
    }
}
