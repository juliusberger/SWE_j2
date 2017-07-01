package app.model.interfaces.Glossary;

import app.model.interfaces.*;

/**
 * Model des Glossars. Gedacht für Halterklassen von {@link I_GlossaryEntry}.
 */
public interface I_Glossary extends I_ModelEntryFactory<I_GlossaryEntry>, I_ObservableDataAdaptor<I_GlossaryEntry>, I_XmlModelEntity, I_Clearable {

}
