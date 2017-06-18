package app.models.interfaces.Requirements;

import app.models.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_CommentEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getKeyword();

    SimpleStringProperty keywordProperty();

    void setKeyword(String keyword);

    String getDescription();

    SimpleStringProperty descriptionProperty();

    void setDescription(String description);
}
