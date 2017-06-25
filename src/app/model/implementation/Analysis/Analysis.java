package app.model.implementation.Analysis;

import app.model.implementation.ObservableEntryHolder;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.Analysis.I_AnalysisEntry;
import app.model.interfaces.I_XmlModelEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
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
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }
}
