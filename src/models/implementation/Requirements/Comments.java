package models.implementation.Requirements;

import models.implementation.ObservableEntryHolder;
import models.interfaces.Requirements.I_CommentEntry;
import models.interfaces.Requirements.I_Comments;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class Comments extends ObservableEntryHolder<I_CommentEntry> implements I_Comments {
    @Override
    public I_CommentEntry createEntry() {
        return new CommentEntry();
    }
}
