package app.model.interfaces.Requirements;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle der Ergänzungen.
 */
public interface I_CommentEntry extends I_ModelPropertyAdaptor, I_XmlModelEntity {
    String getKeyword();

    void setKeyword(String keyword);

    SimpleStringProperty keywordProperty();

    String getDescription();

    void setDescription(String description);

    SimpleStringProperty descriptionProperty();
}
