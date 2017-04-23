package models.partials.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Michi on 23.04.2017.
 */
public class NonFunctionalRequirements
{
    private final ObservableList<NonFunctionalRequirementEntry> entries = FXCollections.observableArrayList();

    public ObservableList<NonFunctionalRequirementEntry> getEntries() {
        return entries;
    }
}
