package app.models.implementation.Glossary;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Glossary.I_Glossary;
import app.models.interfaces.Glossary.I_GlossaryEntry;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary extends ObservableEntryHolder<I_GlossaryEntry> implements I_Glossary {
    @Override
    public I_GlossaryEntry createEntry() {
        return new GlossaryEntry();
    }
}
