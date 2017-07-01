package app.model.implementation.Analysis;

/**
 * Model-Instanz von {@link Analysis} für die Ist-Analyse
 */
public class StateAnalysis extends Analysis {
    @Override
    public String getTag() {
        return "StateAnalysis";
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"entryName", "description"};
    }
}
