package models.partials.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class RequirementEntry {
    private final SimpleStringProperty description;

    RequirementEntry(String description) {
        this.description = new SimpleStringProperty(description);
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
}
