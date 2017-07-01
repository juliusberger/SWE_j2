package app.model.interfaces.Analysis;

import app.model.interfaces.*;

/**
 * Model der Ist- und Soll-Analyse. Gedacht für Halterklassen von {@link I_AnalysisEntry}.
 */
public interface I_Analysis extends I_XmlModelEntity, I_ModelEntryFactory<I_AnalysisEntry>, I_ObservableDataAdaptor<I_AnalysisEntry> {

}
