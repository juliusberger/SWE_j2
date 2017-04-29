package models.Glossary;

import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Glossary extends ObservableDataAdaptor<I_GlossaryEntry> {
    ObservableList<I_GlossaryEntry> getEntries();

    @Override
    void addData(ArrayList<String> dataStrings);

    @Override
    void setData(I_GlossaryEntry entry,
                 ArrayList<String> dataStrings);

    @Override
    ArrayList<String> getData(I_GlossaryEntry entry);
}
