package app.controller;

import app.helpers.I_TableBinding;
import app.helpers.TableBinding;
import app.helpers.ValidateInput;
import app.model.implementation.Project;
import app.model.interfaces.Requirements.*;
import app.model.interfaces.Requirements.I_QualityRequirementEntry.Priority;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class RequirementsController implements Initializable {
    private final I_Requirements _dataModel = Project.getInstance().getRequirements();

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

    public ToggleGroup _tg1;
    public ToggleGroup _tg2;
    public ToggleGroup _tg3;
    public ToggleGroup _tg4;
    public ToggleGroup _tg5;
    public ToggleGroup _tg6;
    public ToggleGroup _tg7;
    public ToggleGroup _tg8;
    public ToggleGroup _tg9;
    public ToggleGroup _tg10;
    public ToggleGroup _tg11;
    public ToggleGroup _tg12;
    public ToggleGroup _tg13;
    public ToggleGroup _tg14;
    public ToggleGroup _tg15;
    public ToggleGroup _tg16;
    public ToggleGroup _tg17;
    public ToggleGroup _tg18;
    public ToggleGroup _tg19;
    public ToggleGroup _tg20;
    public ToggleGroup _tg21;
    public ToggleGroup _tg22;
    public ToggleGroup _tg23;
    public ToggleGroup _tg24;
    public ToggleGroup _tg25;
    public ToggleGroup _tg26;
    public ToggleGroup _tg27;
    public ToggleGroup _tg28;

    public TableView<I_CommentEntry> _commentsTable;
    public Button _commentsAddButton;
    public Button _commentsEditButton;
    public Button _commentsDeleteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _projectGoalText.textProperty().bindBidirectional(_dataModel.projectGoalProperty());
        new ValidateInput(_projectGoalText, ValidateInput.Validator.PLAIN_TEXT);
        _fieldOfApplicationText.textProperty().bindBidirectional(_dataModel.fieldOfApplicationProperty());
        new ValidateInput(_fieldOfApplicationText, ValidateInput.Validator.PLAIN_TEXT);

        I_TableBinding functionalRequirementEntryTableBinding = new TableBinding<>(_functionalRequirementsTable, _dataModel.getFunctionalRequirements());
        functionalRequirementEntryTableBinding.bindAll(_functionalRequirementsAddButton, _functionalRequirementsEditButton, _functionalRequirementsDeleteButton);

        I_TableBinding nonFunctionalRequirementEntryTableBinding = new TableBinding<>(_nonFunctionalRequirementsTable, _dataModel.getNonFunctionalRequirements());
        nonFunctionalRequirementEntryTableBinding.bindAll(_nonFunctionalRequirementsAddButton, _nonFunctionalRequirementsEditButton, _nonFunctionalRequirementsDeleteButton);

        ToggleGroup[] toggleGroups = {_tg1, _tg2, _tg3, _tg4, _tg5, _tg6, _tg7, _tg8, _tg9, _tg10, _tg11, _tg12, _tg13, _tg14, _tg15, _tg16, _tg17, _tg18, _tg19, _tg20, _tg21, _tg22, _tg23, _tg24, _tg25, _tg26, _tg27, _tg28};

        for (int i = 0; i < toggleGroups.length; i++) {
            final ToggleGroup currentToggleGroup = toggleGroups[i];
            final I_QualityRequirementEntry currentQualityRequirementEnrty = _dataModel.getQualityRequirementEntries().get(i);

            toggleGroups[i].selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
                if (currentToggleGroup.getSelectedToggle() != null)
                    currentQualityRequirementEnrty.setPriority(Priority.values()[Integer.parseInt(currentToggleGroup.getSelectedToggle().getUserData().toString())]);
            });

            currentQualityRequirementEnrty.priorityProperty().addListener((observable, oldValue, newValue) -> {
                if (currentQualityRequirementEnrty.getPriority() == Priority.UNSET) {
                    currentToggleGroup.selectToggle(null);
                } else {
                    currentToggleGroup.selectToggle(currentToggleGroup.getToggles().get(currentQualityRequirementEnrty.getPriority().ordinal()));
                }
            });
        }


        I_TableBinding commentEntryTableBinding = new TableBinding<>(_commentsTable, _dataModel.getComments());
        commentEntryTableBinding.bindAll(_commentsAddButton, _commentsEditButton, _commentsDeleteButton);

    }
}
