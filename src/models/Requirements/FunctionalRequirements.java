package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
public class FunctionalRequirements implements ObservableDataAdaptor<FunctionalRequirementEntry> {
    private final ObservableList<FunctionalRequirementEntry> entries = FXCollections.observableArrayList();

    public ObservableList<FunctionalRequirementEntry> getEntries() {
        return this.entries;
    }

    @Override
    public void addData(ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 3) {
            this.entries.add(new FunctionalRequirementEntry(dataStrings.get(0),
                    dataStrings.get(1),
                    dataStrings.get(2)));
        }
    }

    @Override
    public void setData(FunctionalRequirementEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 3) {
            entry.setFunction(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
            entry.setStakeholder(dataStrings.get(2));
        }
    }

    @Override
    public ArrayList<String> getData(FunctionalRequirementEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getFunction());
        stringProperties.add(entry.getDescription());
        stringProperties.add(entry.getStakeholder());
        return stringProperties;
    }
}
