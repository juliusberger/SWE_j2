package app.model.implementation.Requirements;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.I_XmlModelEntity;
import app.model.interfaces.Requirements.I_CommentEntry;
import app.model.interfaces.Requirements.I_Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_Comments}
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
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"keyword", "description"};
    }
}
