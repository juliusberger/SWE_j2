package app.models.implementation.Analysis;

import app.models.implementation.ObservableEntryHolder;
import app.models.interfaces.Analysis.I_Analysis;
import app.models.interfaces.Analysis.I_AnalysisEntry;
import app.models.interfaces.I_XmlModelEntity;

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
        return new ArrayList<>(this.getEntries());
    }


    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {

    }

    @Override
    public ArrayList<String> getAllProperties() {
        return null;
    }
}
