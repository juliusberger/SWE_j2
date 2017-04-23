package testStage;

import models.StateAnalysis;
import models.partials.Analysis.AnalysisEntry;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Test {

    public static void main(String[] args) {
        StateAnalysis s = new StateAnalysis();

        s.getEntries()
                .add(new AnalysisEntry("Test1",
                        "Test2"));
        s.getEntries()
                .add(new AnalysisEntry("Test2",
                        "Test3"));

        System.out.println(new AnalysisEntry("",
                "").descriptionProperty());
    }
}
