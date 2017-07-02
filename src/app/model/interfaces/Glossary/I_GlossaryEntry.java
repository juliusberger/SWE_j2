package app.model.interfaces.Glossary;

import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;

/**
 * Model für einen Eintrag für die Tabelle des Glossars.
 */
public interface I_GlossaryEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getItem();

    void setItem(String item);

    SimpleStringProperty itemProperty();

    String getDefinition();

    void setDefinition(String definition);

    SimpleStringProperty definitionProperty();

    String getDistinction();

    void setDistinction(String distinction);

    SimpleStringProperty distinctionProperty();

    String getValidity();

    void setValidity(String validity);

    SimpleStringProperty validityProperty();

    String getLabel();

    void setLabel(String label);

    SimpleStringProperty labelProperty();
}
