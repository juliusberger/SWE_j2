package models.implementation.Analysis;

import models.implementation.ObservableEntryHolder;
import models.interfaces.Analysis.I_Analysis;
import models.interfaces.Analysis.I_AnalysisEntry;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class Analysis extends ObservableEntryHolder<I_AnalysisEntry> implements I_Analysis {
    @Override
    public I_AnalysisEntry createEntry() {
        return new AnalysisEntry();
    }
}
