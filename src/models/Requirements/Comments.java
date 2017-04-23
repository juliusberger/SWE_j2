package models.Requirements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Comments {
    private final ObservableList<CommentEntry> entries = FXCollections.observableArrayList();

    public ObservableList<CommentEntry> getEntries() {
        return entries;
    }
}
