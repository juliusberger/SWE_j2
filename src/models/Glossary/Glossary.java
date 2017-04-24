package models.Glossary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary implements ObservableDataAdaptor<GlossaryEntry> {
    private final ObservableList<GlossaryEntry> entries = FXCollections.observableArrayList();

    public ObservableList<GlossaryEntry> getEntries() {
        return this.entries;
    }

    @Override
    public void addData(ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            this.entries.add(new GlossaryEntry(dataStrings.get(0),
                    dataStrings.get(1)));
        }
    }

    @Override
    public void setData(GlossaryEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setItem(dataStrings.get(0));
            entry.setDefinition(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(GlossaryEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getItem());
        stringProperties.add(entry.getDefinition());
        return stringProperties;
    }
}
