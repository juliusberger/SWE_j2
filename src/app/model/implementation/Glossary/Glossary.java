package app.model.implementation.Glossary;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.Glossary.I_GlossaryEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_Glossary}
 */
public class Glossary extends ObservableEntryHolder<I_GlossaryEntry> implements I_Glossary {
    @Override
    public I_GlossaryEntry createEntry() {
        return new GlossaryEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public String getTag() {
        return "Glossary";
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"item", "definition", "distinction", "validity", "label"};
    }
}
