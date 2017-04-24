package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class RequirementEntry {
    private final SimpleStringProperty description;

    RequirementEntry(String description) {
        this.description = new SimpleStringProperty(description);
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
}
