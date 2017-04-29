package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 23/04/2017.
 */
interface I_RequirementEntry {
    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
