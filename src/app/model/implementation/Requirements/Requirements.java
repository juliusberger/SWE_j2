package app.model.implementation.Requirements;

import app.model.interfaces.I_XmlModelEntity;
import javafx.beans.property.SimpleStringProperty;
import app.model.interfaces.Requirements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements implements I_Requirements {
    private final SimpleStringProperty _projectGoal = new SimpleStringProperty("");
    private final SimpleStringProperty _fieldOfApplication = new SimpleStringProperty("");

    private final I_FunctionalRequirements _functionalRequirements = new FunctionalRequirements();
    private final I_NonFunctionalRequirements _nonFunctionalRequirements = new NonFunctionalRequirements();

    private final List<I_QualityRequirementEntry> _qualityRequirementEntries = new ArrayList<>(5);

    private final I_Comments _comments = new Comments();

    public Requirements() {
        for (int i = 0; i < 5; i++) {
            this._qualityRequirementEntries.add(new QualityRequirementEntry());
        }
    }

    @Override
    public String getProjectGoal() {
        return this._projectGoal.get();
    }

    @Override
    public SimpleStringProperty projectGoalProperty() {
        return this._projectGoal;
    }

    @Override
    public void setProjectGoal(String projectGoal) {
        this._projectGoal.set(projectGoal);
    }

    @Override
    public String getFieldOfApplication() {
        return this._fieldOfApplication.get();
    }

    @Override
    public SimpleStringProperty fieldOfApplicationProperty() {
        return this._fieldOfApplication;
    }

    @Override
    public void setFieldOfApplication(String fieldOfApplication) {
        this._fieldOfApplication.set(fieldOfApplication);
    }

    @Override
    public I_FunctionalRequirements getFunctionalRequirements() {
        return this._functionalRequirements;
    }

    @Override
    public I_NonFunctionalRequirements getNonFunctionalRequirements() {
        return this._nonFunctionalRequirements;
    }

    @Override
    public List<I_QualityRequirementEntry> getQualityRequirementEntries() {
        return this._qualityRequirementEntries;
    }

    @Override
    public I_Comments getComments() {
        return this._comments;
    }


    @Override
    public List<I_XmlModelEntity> getChildren() {
        List<I_XmlModelEntity> children = new ArrayList<>();
        children.add(getFunctionalRequirements());
        children.add(getNonFunctionalRequirements());
        children.addAll(getQualityRequirementEntries());
        children.add(getComments());
        return children;
    }

    @Override
    public String getTag() {
        return "Requirements";
    }

    @Override
    public void setAllProperties(ArrayList<String> propertyStrings) {
        this.setProjectGoal(propertyStrings.get(0));
        this.setFieldOfApplication(propertyStrings.get(1));
    }

    @Override
    public ArrayList<String> getAllProperties() {
        ArrayList<String> stringProperties = new ArrayList<>();
        stringProperties.add(this.getProjectGoal());
        stringProperties.add(this.getFieldOfApplication());

        return stringProperties;
    }

    @Override
    public void removeExistingData() {
        this.setProjectGoal("");
        this.setFieldOfApplication("");
    }
}