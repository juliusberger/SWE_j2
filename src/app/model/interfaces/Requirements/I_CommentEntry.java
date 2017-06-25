package app.model.interfaces.Requirements;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

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
