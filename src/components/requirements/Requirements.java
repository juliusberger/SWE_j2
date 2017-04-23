package components.requirements;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.partials.Requirements.CommentEntry;
import models.partials.Requirements.FunctionalRequirementEntry;
import models.partials.Requirements.NonFunctionalRequirementEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Requirements implements Initializable {

    public TableView<FunctionalRequirementEntry> functionalRequirementsTable;
    public Button functionalRequirementsAddButton;
    public Button functionalRequirementsEditButton;
    public Button functionalRequirementsDeleteButton;

    public TableView<NonFunctionalRequirementEntry> nonFunctionalRequirementsTable;
    public Button nonFunctionalRequirementsAddButton;
    public Button nonFunctionalRequirementsEditButton;
    public Button nonFunctionalRequirementsDeleteButton;

    public TableView<CommentEntry> commentsTable;
    public Button commentsAddButton;
    public Button commentsEditButton;
    public Button commentsDeleteButton;


    private models.Requirements data = new models.Requirements("",
            "");

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        TableBinding.bindTableToData(functionalRequirementsTable,
                data.getFunctionalRequirements().getEntries(),
                "function",
                "stakeholder",
                "description");
        TableBinding.observeDisabledButtonState(functionalRequirementsTable,
                functionalRequirementsEditButton,
                functionalRequirementsDeleteButton);
        TableBinding.bindTableDeleteButton(functionalRequirementsTable,
                functionalRequirementsDeleteButton);

        TableBinding.bindTableToData(nonFunctionalRequirementsTable,
                data.getNonFunctionalRequirements().getEntries(),
                "businessProcess",
                "description");
        TableBinding.observeDisabledButtonState(nonFunctionalRequirementsTable,
                nonFunctionalRequirementsEditButton,
                nonFunctionalRequirementsDeleteButton);
        TableBinding.bindTableDeleteButton(nonFunctionalRequirementsTable,
                nonFunctionalRequirementsDeleteButton);

        TableBinding.bindTableToData(commentsTable,
                data.getComments().getEntries(),
                "keyword",
                "description");
        TableBinding.observeDisabledButtonState(commentsTable,
                commentsEditButton,
                commentsDeleteButton);
        TableBinding.bindTableDeleteButton(commentsTable,
                commentsDeleteButton);


    }
}
