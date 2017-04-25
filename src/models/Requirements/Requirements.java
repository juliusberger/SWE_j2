package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements {
    private final SimpleStringProperty projectGoal;
    private final SimpleStringProperty fieldOfApplication;

    private final FunctionalRequirements functionalRequirements = new FunctionalRequirements();
    private final NonFunctionalRequirements nonFunctionalRequirements = new NonFunctionalRequirements();

    private final List<QualityRequirementEntry> qualityRequirementEntries = new ArrayList<>(5);

    private final Comments comments = new Comments();

    public Requirements(String projectGoal,
                        String fieldOfApplication) {
        this.projectGoal = new SimpleStringProperty(projectGoal);
        this.fieldOfApplication = new SimpleStringProperty(fieldOfApplication);
        for (int i = 0; i < 5; i++) {
            this.qualityRequirementEntries.add(new QualityRequirementEntry());
        }
    }

    public String getProjectGoal() {
        return this.projectGoal.get();
    }

    public SimpleStringProperty projectGoalProperty() {
        return this.projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal.set(projectGoal);
    }

    public String getFieldOfApplication() {
        return this.fieldOfApplication.get();
    }

    public SimpleStringProperty fieldOfApplicationProperty() {
        return this.fieldOfApplication;
    }

    public void setFieldOfApplication(String fieldOfApplication) {
        this.fieldOfApplication.set(fieldOfApplication);
    }

    public FunctionalRequirements getFunctionalRequirements() {
        return this.functionalRequirements;
    }

    public NonFunctionalRequirements getNonFunctionalRequirements() {
        return this.nonFunctionalRequirements;
    }

    public List<QualityRequirementEntry> getQualityRequirementEntries() {
        return this.qualityRequirementEntries;
    }

    public Comments getComments() {
        return this.comments;
    }
}
