package models.Glossary;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class GlossaryEntry {
    private final SimpleStringProperty item;
    private final SimpleStringProperty definition;

    GlossaryEntry(String item,
                  String definition) {
        this.item = new SimpleStringProperty(item);
        this.definition = new SimpleStringProperty(definition);
    }

    String getItem() {
        return this.item.get();
    }

    public SimpleStringProperty itemProperty() {
        return this.item;
    }

    void setItem(String item) {
        this.item.set(item);
    }

    String getDefinition() {
        return this.definition.get();
    }

    public SimpleStringProperty definitionProperty() {
        return this.definition;
    }

    void setDefinition(String definition) {
        this.definition.set(definition);
    }
}
