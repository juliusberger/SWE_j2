package app.models.implementation.Glossary;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.Glossary.I_GlossaryEntry;
import app.models.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary extends ObservableEntryHolder<I_GlossaryEntry> implements I_Glossary {
    @Override
    public I_GlossaryEntry createEntry() {
        return new GlossaryEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(this.getEntries());
    }

    @Override
    public String getTag() {
        return "Glossary";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void removeExistingData() {
        this.getEntries().clear();
    }
}
