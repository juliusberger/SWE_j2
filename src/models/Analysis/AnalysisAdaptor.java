package models.Analysis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class AnalysisAdaptor implements ObservableDataAdaptor<AnalysisEntry> {
    private ObservableList<AnalysisEntry> entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<AnalysisEntry> getEntries() {
        return this.entries;
    }

    @Override
    public void addData(ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            this.entries.add(new AnalysisEntry(dataStrings.get(0),
                    dataStrings.get(1)));
        }
    }

    // TODO: vllt interface für Getter und Setter in alle Klassen wie <AnalysisEntry> --> Setzen der Daten wie in Constructor

    @Override
    public void setData(AnalysisEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setEntryName(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(AnalysisEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getEntryName());
        stringProperties.add(entry.getDescription());
        return stringProperties;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("Currently in List: \n");
        for (AnalysisEntry e : this.entries) {
            str.append(e.toString());
        }
        return str.toString();
    }
}
