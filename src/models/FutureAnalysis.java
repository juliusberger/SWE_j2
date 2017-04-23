package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michi on 23.04.2017.
 */
public class FutureAnalysis
{
    private Map<String, String> entriesMap = new HashMap<String, String>();

    private ObservableMap<String, String> entries = FXCollections.observableMap(entriesMap);

    public void addEntry(String entry, String description)
    {
        entries.put(entry, description);
    }

    public String getDescription(String entry)
    {
        return entries.get(entry);
    }

    public void deleteEntry(String entry)
    {
        entries.remove(entry);
    }
}
