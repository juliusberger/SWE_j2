package models.partials.Requirements;

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
        return keyword.get();
    }

    public SimpleStringProperty keywordProperty() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword.set(keyword);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }
}
