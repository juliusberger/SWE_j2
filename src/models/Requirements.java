package models;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michi on 23.04.2017.
 */
public class Requirements
{
    private final SimpleStringProperty projectAims;
    private final SimpleStringProperty fieldOfApplication;
    private List<FunctionalRequirement> functionalRequirementsList = new ArrayList<FunctionalRequirement>();
    private List<NonFunctionalRequirement> nonFunctionalRequirementsList = new ArrayList<NonFunctionalRequirement>();
    private List<QualityRequirement> qualityRequirementsList = new ArrayList<QualityRequirement>();
    private List<Comment> commentList = new ArrayList<Comment>();

    ObservableList<FunctionalRequirement> functionalRequirements = FXCollections.observableList(functionalRequirementsList);
    ObservableList<NonFunctionalRequirement> nonFunctionalRequirements = FXCollections.observableList(nonFunctionalRequirementsList);
    ObservableList<QualityRequirement> qualityRequirements = FXCollections.observableList(qualityRequirementsList);
    ObservableList<Comment> comments = FXCollections.observableList(commentList);

    public Requirements(String projectAims,
                        String fieldOfApplication)
    {
        this.projectAims = new SimpleStringProperty(projectAims);
        this.fieldOfApplication = new SimpleStringProperty(fieldOfApplication);
    }

    public String getProjectAims()
    {
        return projectAims.get();
    }

    public SimpleStringProperty projectAimsProperty()
    {
        return projectAims;
    }

    public void setProjectAims(String projectAims)
    {
        this.projectAims.set(projectAims);
    }

    public String getFieldOfApplication()
    {
        return fieldOfApplication.get();
    }

    public SimpleStringProperty fieldOfApplicationProperty()
    {
        return fieldOfApplication;
    }

    public void setFieldOfApplication(String fieldOfApplication)
    {
        this.fieldOfApplication.set(fieldOfApplication);
    }

    public ObservableList<FunctionalRequirement> getFunctionalRequirements()
    {
        return functionalRequirements;
    }

    public void setFunctionalRequirements(ObservableList<FunctionalRequirement> functionalRequirements)
    {
        this.functionalRequirements = functionalRequirements;
    }

    public ObservableList<NonFunctionalRequirement> getNonFunctionalRequirements()
    {
        return nonFunctionalRequirements;
    }

    public void setNonFunctionalRequirements(ObservableList<NonFunctionalRequirement> nonFunctionalRequirements)
    {
        this.nonFunctionalRequirements = nonFunctionalRequirements;
    }

    public ObservableList<QualityRequirement> getQualityRequirements()
    {
        return qualityRequirements;
    }

    public void setQualityRequirements(ObservableList<QualityRequirement> qualityRequirements)
    {
        this.qualityRequirements = qualityRequirements;
    }

    public ObservableList<Comment> getComments()
    {
        return comments;
    }

    public void setComments(ObservableList<Comment> comments)
    {
        this.comments = comments;
    }

    public void addFunctionalRequirement(FunctionalRequirement functionalRequirement)
    {
        this.functionalRequirements.add(functionalRequirement);
    }

    public void addNonFunctionalRequirement(NonFunctionalRequirement nonFunctionalRequirement)
    {
        this.nonFunctionalRequirements.add(nonFunctionalRequirement);
    }

    public void addQualityRequirement(QualityRequirement qualityRequirement)
    {
        this.qualityRequirements.add(qualityRequirement);
    }

    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }

    public void deleteFunctionalRequirement(FunctionalRequirement functionalRequirement)
    {
        this.functionalRequirements.remove(functionalRequirement);
    }

    public void deleteNonFunctionalRequirement(NonFunctionalRequirement nonFunctionalRequirement)
    {
        this.nonFunctionalRequirements.remove(nonFunctionalRequirement);
    }

    public void deleteQualityRequirement(QualityRequirement qualityRequirement)
    {
        this.qualityRequirements.remove(qualityRequirement);
    }

    public void deleteComment(Comment comment)
    {
        this.comments.remove(comment);
    }
}
