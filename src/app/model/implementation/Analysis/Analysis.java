package app.model.implementation.Analysis;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.Analysis.I_AnalysisEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Model-Implementierung von {@link I_Analysis}
 */
abstract class Analysis extends ObservableEntryHolder<I_AnalysisEntry> implements I_Analysis {
    @Override
    public I_AnalysisEntry createEntry() {
        return new AnalysisEntry();
    }

    @Override
    public List<I_XmlModelEntity> getChildren() {
        return new ArrayList<>(getEntries());
    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
    }

}
