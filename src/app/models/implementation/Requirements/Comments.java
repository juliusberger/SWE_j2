package app.models.implementation.Requirements;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Requirements.I_CommentEntry;
import app.models.interfaces.Requirements.I_Comments;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class Comments extends ObservableEntryHolder<I_CommentEntry> implements I_Comments {
    @Override
    public I_CommentEntry createEntry() {
        return new CommentEntry();
    }
}
