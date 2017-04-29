package models.Requirements;

import javafx.collections.ObservableList;
import models.ObservableDataAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Comments extends ObservableDataAdaptor<I_CommentEntry> {
    ObservableList<I_CommentEntry> getEntries();
}
