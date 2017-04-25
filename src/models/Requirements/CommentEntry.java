package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Michi on 23.04.2017.
 */
public class CommentEntry
{
    private final SimpleStringProperty keyword;
    private final SimpleStringProperty description;

    public CommentEntry(String keyword,
                 String description) {
        this.keyword = new SimpleStringProperty(keyword);
        this.description = new SimpleStringProperty(description);
    }

    public String getKeyword() {
        return this.keyword.get();
    }

    public SimpleStringProperty keywordProperty() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword.set(keyword);
    }

    public String getDescription() {
        return this.description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
