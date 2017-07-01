package app.model.implementation.Analysis;

/**
 * Model-Instanz von {@link Analysis} für die Soll-Analyse
 */
public class FutureAnalysis extends Analysis {
    @Override
    public String getTag() {
        return "FutureAnalysis";
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"entryName", "description"};
    }
}
