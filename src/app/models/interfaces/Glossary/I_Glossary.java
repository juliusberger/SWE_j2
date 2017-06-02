package app.models.interfaces.Glossary;

import app.models.interfaces.I_ModelEntryFactory;
import app.models.interfaces.I_ObservableDataAdaptor;
import app.models.interfaces.I_XmlExportable;
import app.models.interfaces.I_XmlImportable;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_Glossary extends I_ModelEntryFactory<I_GlossaryEntry>, I_ObservableDataAdaptor<I_GlossaryEntry>, I_XmlExportable, I_XmlImportable {

}
