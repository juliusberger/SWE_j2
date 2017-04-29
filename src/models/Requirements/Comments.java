package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Comments implements I_Comments {
    private final ObservableList<I_CommentEntry> entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<I_CommentEntry> getEntries() {
        return this.entries;
    }

    @Override
    public void addData(ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            this.entries.add(new CommentEntry(dataStrings.get(0),
                    dataStrings.get(1)));
        }
    }

    @Override
    public void setData(I_CommentEntry entry,
                        ArrayList<String> dataStrings) {
        if (dataStrings.size() >= 2) {
            entry.setKeyword(dataStrings.get(0));
            entry.setDescription(dataStrings.get(1));
        }
    }

    @Override
    public ArrayList<String> getData(I_CommentEntry entry) {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(entry.getKeyword());
        stringProperties.add(entry.getDescription());
        return stringProperties;
    }
}
