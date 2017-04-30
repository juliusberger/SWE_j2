package models.Requirements;

import models.ObservableEntryHolder;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class Comments extends ObservableEntryHolder<I_CommentEntry> implements I_Comments {
    @Override
    public I_CommentEntry createEntry() {
        return new CommentEntry();
    }
}
