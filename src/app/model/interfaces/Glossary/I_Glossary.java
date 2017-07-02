package app.model.interfaces.Glossary;

import app.model.interfaces.I_Clearable;
import app.model.interfaces.I_ModelEntryFactory;
import app.model.interfaces.I_ObservableDataAdaptor;
import app.model.interfaces.I_XmlModelEntity;

/**
 * Model des Glossars. Gedacht für Halterklassen von {@link I_GlossaryEntry}.
 */
public interface I_Glossary extends I_ModelEntryFactory<I_GlossaryEntry>, I_ObservableDataAdaptor<I_GlossaryEntry>, I_XmlModelEntity, I_Clearable {

}
