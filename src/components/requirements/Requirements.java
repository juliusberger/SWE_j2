package components.requirements;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import models.Requirements.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements implements Initializable {

    public TextArea projectGoalText;
    public TextArea fieldOfApplicationText;

    public TableView<I_FunctionalRequirementEntry> functionalRequirementsTable;
    public Button functionalRequirementsAddButton;
    public Button functionalRequirementsEditButton;
    public Button functionalRequirementsDeleteButton;

    public TableView<I_NonFunctionalRequirementEntry> nonFunctionalRequirementsTable;
    public Button nonFunctionalRequirementsAddButton;
    public Button nonFunctionalRequirementsEditButton;
    public Button nonFunctionalRequirementsDeleteButton;


    public ToggleGroup tg1;
    public ToggleGroup tg2;
    public ToggleGroup tg3;
    public ToggleGroup tg4;
    public ToggleGroup tg5;


    public TableView<I_CommentEntry> commentsTable;
    public Button commentsAddButton;
    public Button commentsEditButton;
    public Button commentsDeleteButton;


    private I_Requirements data = new models.Requirements.Requirements("",
            "");

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        this.projectGoalText.textProperty().bindBidirectional(this.data.projectGoalProperty());
        this.fieldOfApplicationText.textProperty().bindBidirectional(this.data.fieldOfApplicationProperty());

        TableBinding<I_FunctionalRequirementEntry> functionalRequirementEntryTableBinding = new TableBinding<>(this.functionalRequirementsTable,
                this.data.getFunctionalRequirements(),
                "function",
                "description",
                "stakeholder");
        functionalRequirementEntryTableBinding.bindAll(this.functionalRequirementsAddButton,
                this.functionalRequirementsEditButton,
                this.functionalRequirementsDeleteButton);

        TableBinding<I_NonFunctionalRequirementEntry> nonFunctionalRequirementEntryTableBinding = new TableBinding<>(this.nonFunctionalRequirementsTable,
                this.data.getNonFunctionalRequirements(),
                "businessProcess",
                "description");
        nonFunctionalRequirementEntryTableBinding.bindAll(this.nonFunctionalRequirementsAddButton,
                this.nonFunctionalRequirementsEditButton,
                this.nonFunctionalRequirementsDeleteButton);

        ToggleGroup[] toggleGroups = {this.tg1, this.tg2, this.tg3, this.tg4, this.tg5};
        for (int i = 0; i < toggleGroups.length; i++) {
            int finalI = i;
            toggleGroups[i].selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
                this.data.getQualityRequirementEntries()
                        .get(finalI)
                        .setPriority(I_QualityRequirementEntry.Priority.values()[Integer.parseInt(toggleGroups[finalI].getSelectedToggle()
                                .getUserData()
                                .toString())]);
                System.out.println(this.data.getQualityRequirementEntries().get(finalI).getPriority().toString());
            });
        }


        TableBinding<I_CommentEntry> commentEntryTableBinding = new TableBinding<>(this.commentsTable,
                this.data.getComments(),
                "keyword",
                "description");
        commentEntryTableBinding.bindAll(this.commentsAddButton,
                this.commentsEditButton,
                this.commentsDeleteButton);

    }
}
