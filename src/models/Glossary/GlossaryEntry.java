package models.Glossary;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class GlossaryEntry implements I_GlossaryEntry {
    private final SimpleStringProperty item;
    private final SimpleStringProperty definition;

    public GlossaryEntry(String item,
                         String definition) {
        this.item = new SimpleStringProperty(item);
        this.definition = new SimpleStringProperty(definition);
    }

    @Override
    public String getItem() {
        return this.item.get();
    }

    @Override
    public SimpleStringProperty itemProperty() {
        return this.item;
    }

    @Override
    public void setItem(String item) {
        this.item.set(item);
    }

    @Override
    public String getDefinition() {
        return this.definition.get();
    }

    @Override
    public SimpleStringProperty definitionProperty() {
        return this.definition;
    }

    @Override
    public void setDefinition(String definition) {
        this.definition.set(definition);
    }
}
