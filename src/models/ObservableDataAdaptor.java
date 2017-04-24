package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 24/04/2017.
 */
public interface ObservableDataAdaptor<S> {
    void addData(ArrayList<String> dataStrings);

    void setData(S entry,
                 ArrayList<String> dataStrings);

    ArrayList<String> getData(S entry);

    ObservableList<S> getEntries();
}
