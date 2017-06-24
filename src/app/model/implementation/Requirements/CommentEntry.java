package app.model.implementation.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.Requirements.I_CommentEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michi on 23.04.2017.
 */
public class CommentEntry implements I_CommentEntry {
    private final SimpleStringProperty _keyword = new SimpleStringProperty("");
    private final SimpleStringProperty _description = new SimpleStringProperty("");

    CommentEntry() {
    }

    @Override
    public String getKeyword() {
        return _keyword.get();
    }

    @Override
    public SimpleStringProperty keywordProperty() {
        return _keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        _keyword.set(keyword);
    }

    @Override
    public String getDescription() {
        return _description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description.set(description);
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return null;
    }

    @Override
    public String getTag() {
        return "CommentEntry";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        try {
            setKeyword(propertyStrings.get(0));
            setDescription(propertyStrings.get(1));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(getKeyword());
        stringProperties.add(getDescription());

        return stringProperties;
    }
}
