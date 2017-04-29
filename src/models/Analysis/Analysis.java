package models.Analysis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class Analysis implements I_Analysis {
    private ObservableList<I_AnalysisEntry> entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<I_AnalysisEntry> getEntries() {
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
    public void setData(I_AnalysisEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setEntryName(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(I_AnalysisEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getEntryName());
        stringProperties.add(entry.getDescription());
        return stringProperties;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("Currently in List: \n");
        for (I_AnalysisEntry e : this.entries) {
            str.append(e.toString());
        }
        return str.toString();
    }
}
