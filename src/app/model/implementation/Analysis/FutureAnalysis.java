package app.model.implementation.Analysis;

/**
 * Created by Michi on 23.04.2017.
 */
public class FutureAnalysis extends Analysis {
    @Override
    public String getTag() {
        return "FutureAnalysis";
    }


    public void removeExistingData() {
        this.getEntries().clear();
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"entryName", "description"};
    }
}
