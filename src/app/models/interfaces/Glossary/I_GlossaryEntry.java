package app.models.interfaces.Glossary;

import app.models.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.models.interfaces.I_ModelPropertyAdaptor;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_GlossaryEntry extends I_XmlModelEntity, I_ModelPropertyAdaptor {
    String getItem();

    SimpleStringProperty itemProperty();

    void setItem(String item);

    String getDefinition();

    SimpleStringProperty definitionProperty();

    void setDefinition(String definition);
}
