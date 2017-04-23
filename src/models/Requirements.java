package models;

import javafx.beans.property.SimpleStringProperty;
import models.partials.Requirements.Comments;
import models.partials.Requirements.FunctionalRequirements;
import models.partials.Requirements.NonFunctionalRequirements;
import models.partials.Requirements.QualityRequirement;

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

    private final List<QualityRequirement> qualityRequirements = new ArrayList<>(5);

    private final Comments comments = new Comments();

    public Requirements(String projectGoal,
                        String fieldOfApplication) {
        this.projectGoal = new SimpleStringProperty(projectGoal);
        this.fieldOfApplication = new SimpleStringProperty(fieldOfApplication);
    }

    public String getProjectGoal() {
        return projectGoal.get();
    }

    public SimpleStringProperty projectGoalProperty() {
        return projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal.set(projectGoal);
    }

    public String getFieldOfApplication() {
        return fieldOfApplication.get();
    }

    public SimpleStringProperty fieldOfApplicationProperty() {
        return fieldOfApplication;
    }

    public void setFieldOfApplication(String fieldOfApplication) {
        this.fieldOfApplication.set(fieldOfApplication);
    }

    public FunctionalRequirements getFunctionalRequirements() {
        return functionalRequirements;
    }

    public NonFunctionalRequirements getNonFunctionalRequirements() {
        return nonFunctionalRequirements;
    }

    public List<QualityRequirement> getQualityRequirements() {
        return qualityRequirements;
    }

    public Comments getComments() {
        return comments;
    }
}
