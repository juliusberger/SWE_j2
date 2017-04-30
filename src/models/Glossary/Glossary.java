package models.Glossary;

import models.ObservableEntryHolder;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary extends ObservableEntryHolder<I_GlossaryEntry> implements I_Glossary {
    @Override
    public I_GlossaryEntry createEntry() {
        return new GlossaryEntry();
    }
}
