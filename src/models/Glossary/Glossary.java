package models.Glossary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public class Glossary implements I_Glossary {
    private final ObservableList<I_GlossaryEntry> entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<I_GlossaryEntry> getEntries() {
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
    public void setData(I_GlossaryEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setItem(dataStrings.get(0));
            entry.setDefinition(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(I_GlossaryEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getItem());
        stringProperties.add(entry.getDefinition());
        return stringProperties;
    }
}
