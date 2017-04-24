package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
public class NonFunctionalRequirements implements ObservableDataAdaptor<NonFunctionalRequirementEntry> {
    private final ObservableList<NonFunctionalRequirementEntry> entries = FXCollections.observableArrayList();

    public ObservableList<NonFunctionalRequirementEntry> getEntries() {
        return this.entries;
    }

    @Override
    public void addData(ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            this.entries.add(new NonFunctionalRequirementEntry(dataStrings.get(0),
                    dataStrings.get(1)));
        }
    }

    @Override
    public void setData(NonFunctionalRequirementEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setBusinessProcess(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(NonFunctionalRequirementEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getBusinessProcess());
        stringProperties.add(entry.getDescription());
        return stringProperties;
    }
}
