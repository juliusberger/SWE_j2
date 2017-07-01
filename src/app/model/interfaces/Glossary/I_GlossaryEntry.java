package app.model.interfaces.Glossary;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle des Glossars.
 */
public interface I_GlossaryEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getItem();

    SimpleStringProperty itemProperty();

    void setItem(String item);

    String getDefinition();

    SimpleStringProperty definitionProperty();

    void setDefinition(String definition);

    String getDistinction();

    SimpleStringProperty distinctionProperty();

    void setDistinction(String distinction);

    String getValidity();

    SimpleStringProperty validityProperty();

    void setValidity(String validity);

    String getLabel();

    SimpleStringProperty labelProperty();

    void setLabel(String label);
}
