package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Michi on 23.04.2017.
 */
public class FunctionalRequirements {
    private final ObservableList<FunctionalRequirementEntry> entries = FXCollections.observableArrayList();

    public ObservableList<FunctionalRequirementEntry> getEntries() {
        return entries;
    }
}
