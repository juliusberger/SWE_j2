package app.model.implementation.Analysis;

/**
 * Created by Michi on 23.04.2017.
 */
public class StateAnalysis extends Analysis {

    @Override
    public String getTag() {
        return "StateAnalysis";
    }

    public void removeExistingData() {
        getEntries().clear();
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"entryName", "description"};
    }
}
