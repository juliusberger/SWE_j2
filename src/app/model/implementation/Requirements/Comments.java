package app.model.implementation.Requirements;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_CommentEntry;
import app.model.interfaces.Requirements.I_Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
class Comments extends ObservableEntryHolder<I_CommentEntry> implements I_Comments {
    @Override
    public I_CommentEntry createEntry() {
        return new CommentEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public String getTag() {
        return "Comments";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void removeExistingData() {
        this.getEntries().clear();
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"keyword", "description"};
    }
}
