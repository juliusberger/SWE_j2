package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by Michi on 23.04.2017.
 */
public class FunctionalRequirements implements I_FunctionalRequirements {
    private final ObservableList<I_FunctionalRequirementEntry> entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<I_FunctionalRequirementEntry> getEntries() {
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
    public void setData(I_FunctionalRequirementEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 3) {
            entry.setFunction(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
            entry.setStakeholder(dataStrings.get(2));
        }
    }

    @Override
    public ArrayList<String> getData(I_FunctionalRequirementEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getFunction());
        stringProperties.add(entry.getDescription());
        stringProperties.add(entry.getStakeholder());
        return stringProperties;
    }
}
