package app.model.implementation.Glossary;

import app.model.interfaces.Glossary.I_GlossaryEntry;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class GlossaryEntry implements I_GlossaryEntry {
    private final SimpleStringProperty _item = new SimpleStringProperty("");
    private final SimpleStringProperty _definition = new SimpleStringProperty("");

    GlossaryEntry() {
    }

    @Override
    public String getItem() {
        return _item.get();
    }

    @Override
    public void setItem(String item) {
        _item.set(item);
    }

    @Override
    public SimpleStringProperty itemProperty() {
        return _item;
    }

    @Override
    public String getDefinition() {
        return _definition.get();
    }

    @Override
    public void setDefinition(String definition) {
        _definition.set(definition);
    }

    @Override
    public SimpleStringProperty definitionProperty() {
        return _definition;
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> properties) {

    }

    @Override
    public String getTag() {
        return "GlossaryEntry";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getItem());
        stringProperties.add(getDefinition());

        return stringProperties;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setItem(propertyStrings.get(0));
            setDefinition(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

}
