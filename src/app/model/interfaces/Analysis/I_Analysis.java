package app.model.interfaces.Analysis;

import app.model.interfaces.I_ModelEntryFactory;
import app.model.interfaces.I_ObservableDataAdaptor;
import app.model.interfaces.I_XmlModelEntity;

/**
 * Model der Ist- und Soll-Analyse. Gedacht für Halterklassen von {@link I_AnalysisEntry}.
 */
public interface I_Analysis extends I_XmlModelEntity, I_ModelEntryFactory<I_AnalysisEntry>, I_ObservableDataAdaptor<I_AnalysisEntry> {

}
