package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Michi on 23.04.2017.
 */
public class CommentEntry implements I_CommentEntry {
    private final SimpleStringProperty keyword;
    private final SimpleStringProperty description;

    public CommentEntry(String keyword,
                 String description) {
        this.keyword = new SimpleStringProperty(keyword);
        this.description = new SimpleStringProperty(description);
    }

    @Override
    public String getKeyword() {
        return this.keyword.get();
    }

    @Override
    public SimpleStringProperty keywordProperty() {
        return this.keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword.set(keyword);
    }

    @Override
    public String getDescription() {
        return this.description.get();
    }

    @Override
    public SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description.set(description);
    }
}
