package app.models.interfaces.Requirements;

import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_CommentEntry extends I_ModelPropertyAdaptor {
    String getKeyword();

    SimpleStringProperty keywordProperty();

    void setKeyword(String keyword);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
