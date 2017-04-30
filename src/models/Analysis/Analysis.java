package models.Analysis;

import models.ObservableEntryHolder;

/**
 * Erstellt von Julius am 23/04/2017.
 */
abstract class Analysis extends ObservableEntryHolder<I_AnalysisEntry> implements I_Analysis {
    @Override
    public I_AnalysisEntry createEntry() {
        return new AnalysisEntry();
    }
}
