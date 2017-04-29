package models.Analysis;

import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Analysis extends ObservableDataAdaptor<I_AnalysisEntry> {
    @Override
    ObservableList<I_AnalysisEntry> getEntries();

    @Override
    void addData(ArrayList<String> dataStrings);

    @Override
    void setData(I_AnalysisEntry entry,
                 ArrayList<String> dataStrings);

    @Override
    ArrayList<String> getData(I_AnalysisEntry entry);
}
