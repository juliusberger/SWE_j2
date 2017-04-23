package models.Analysis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class Analysis {
    private ObservableList<AnalysisEntry> entries = FXCollections.observableArrayList();

    // Methoden sind durch ObservableList implementiert
//    public void addEntryButton(AnalysisEntry analysisEntry)
//    {
//        entries.add(analysisEntry);
//    }
//
//    public void deleteEntryButton(AnalysisEntry analysisEntry)
//    {
//        entries.remove(analysisEntry);
//    }

    public ObservableList<AnalysisEntry> getEntries() {
        return entries;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("Currently in List: \n");
        for (AnalysisEntry e : entries) {
            str.append(e.toString());
        }
        return str.toString();
    }
}
