package app.models.implementation.Analysis;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Analysis.I_Analysis;
import app.models.interfaces.Analysis.I_AnalysisEntry;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class Analysis extends ObservableEntryHolder<I_AnalysisEntry> implements I_Analysis {
    @Override
    public I_AnalysisEntry createEntry() {
        return new AnalysisEntry();
    }
}
