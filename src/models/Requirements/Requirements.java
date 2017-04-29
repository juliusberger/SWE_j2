package models.Requirements;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements implements I_Requirements {
    private final SimpleStringProperty projectGoal;
    private final SimpleStringProperty fieldOfApplication;

    private final I_FunctionalRequirements IFunctionalRequirements = new FunctionalRequirements();
    private final I_NonFunctionalRequirements INonFunctionalRequirements = new NonFunctionalRequirements();

    private final List<I_QualityRequirementEntry> qualityRequirementEntries = new ArrayList<>(5);

    private final I_Comments IComments = new Comments();

    public Requirements(String projectGoal,
                        String fieldOfApplication) {
        this.projectGoal = new SimpleStringProperty(projectGoal);
        this.fieldOfApplication = new SimpleStringProperty(fieldOfApplication);
        for (int i = 0; i < 5; i++) {
            this.qualityRequirementEntries.add(new QualityRequirementEntry());
        }
    }

    @Override
    public String getProjectGoal() {
        return this.projectGoal.get();
    }

    @Override
    public SimpleStringProperty projectGoalProperty() {
        return this.projectGoal;
    }

    @Override
    public void setProjectGoal(String projectGoal) {
        this.projectGoal.set(projectGoal);
    }

    @Override
    public String getFieldOfApplication() {
        return this.fieldOfApplication.get();
    }

    @Override
    public SimpleStringProperty fieldOfApplicationProperty() {
        return this.fieldOfApplication;
    }

    @Override
    public void setFieldOfApplication(String fieldOfApplication) {
        this.fieldOfApplication.set(fieldOfApplication);
    }

    @Override
    public I_FunctionalRequirements getFunctionalRequirements() {
        return this.IFunctionalRequirements;
    }

    @Override
    public I_NonFunctionalRequirements getNonFunctionalRequirements() {
        return this.INonFunctionalRequirements;
    }

    @Override
    public List<I_QualityRequirementEntry> getQualityRequirementEntries() {
        return this.qualityRequirementEntries;
    }

    @Override
    public I_Comments getComments() {
        return this.IComments;
    }
}
