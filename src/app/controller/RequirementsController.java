package app.controller;

import app.helpers.I_TableBinding;
import app.helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import app.model.implementation.Project;
import app.model.interfaces.Requirements.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class RequirementsController implements Initializable {

    public TextArea _projectGoalText;
    public TextArea _fieldOfApplicationText;

    public TableView<I_FunctionalRequirementEntry> _functionalRequirementsTable;
    public Button _functionalRequirementsAddButton;
    public Button _functionalRequirementsEditButton;
    public Button _functionalRequirementsDeleteButton;

    public TableView<I_NonFunctionalRequirementEntry> _nonFunctionalRequirementsTable;
    public Button _nonFunctionalRequirementsAddButton;
    public Button _nonFunctionalRequirementsEditButton;
    public Button _nonFunctionalRequirementsDeleteButton;


    // TODO: ordentliche Namen
    public ToggleGroup _tg1;
    public ToggleGroup _tg2;
    public ToggleGroup _tg3;
    public ToggleGroup _tg4;
    public ToggleGroup _tg5;


    public TableView<I_CommentEntry> _commentsTable;
    public Button _commentsAddButton;
    public Button _commentsEditButton;
    public Button _commentsDeleteButton;


    private final I_Requirements _data = Project.getInstance().getRequirements();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        _projectGoalText.textProperty().bindBidirectional(_data.projectGoalProperty());
        _fieldOfApplicationText.textProperty().bindBidirectional(_data.fieldOfApplicationProperty());

        I_TableBinding functionalRequirementEntryTableBinding = new TableBinding<>(_functionalRequirementsTable,
                _data.getFunctionalRequirements());
        functionalRequirementEntryTableBinding.bindAll(_functionalRequirementsAddButton,
                _functionalRequirementsEditButton,
                _functionalRequirementsDeleteButton);

        I_TableBinding nonFunctionalRequirementEntryTableBinding = new TableBinding<>(_nonFunctionalRequirementsTable,
                _data.getNonFunctionalRequirements());
        nonFunctionalRequirementEntryTableBinding.bindAll(_nonFunctionalRequirementsAddButton,
                _nonFunctionalRequirementsEditButton,
                _nonFunctionalRequirementsDeleteButton);

        ToggleGroup[] toggleGroups = {_tg1, _tg2, _tg3, _tg4, _tg5};
        for (int i = 0; i < toggleGroups.length; i++) {
            int finalI = i;
            toggleGroups[i].selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
                _data.getQualityRequirementEntries()
                        .get(finalI)
                        .setPriority(I_QualityRequirementEntry.Priority.values()[Integer.parseInt(toggleGroups[finalI].getSelectedToggle()
                                .getUserData()
                                .toString())]);
                System.out.println(_data.getQualityRequirementEntries().get(finalI).getPriority().toString());
            });
        }


        I_TableBinding commentEntryTableBinding = new TableBinding<>(_commentsTable,
                _data.getComments());
        commentEntryTableBinding.bindAll(_commentsAddButton,
                _commentsEditButton,
                _commentsDeleteButton);

    }
}
