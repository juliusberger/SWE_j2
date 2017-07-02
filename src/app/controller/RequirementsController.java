package app.controller;

import app.helpers.I_TableBinding;
import app.helpers.TableBinding;
import app.helpers.ValidateInput;
import app.helpers.ValidateInput.Validator;
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
 * Controller für das Lastenheft (view/requirements.fxml).
 * Folgende View-Elemente werden wie folgt an ihre Model-Repräsentation gebunden:
 * - jedes Textfeld wird an seine Model-Repräsentation gebunden und mit einer entsprechenden Validierung versehen.
 * - das Model {@link I_FunctionalRequirements} wird an die entsprechende Tabelle gebunden, um die Einträge des Typs {@link I_FunctionalRequirementEntry} zu verwalten.
 * - das Model {@link I_NonFunctionalRequirements} wird an die entsprechende Tabelle gebunden, um die Einträge des Typs {@link I_NonFunctionalRequirementEntry} zu verwalten.
 * - die einzelnen {@link I_QualityRequirementEntry} werden an die jeweilige ToggleGroup gebunden.
 * - das Model {@link I_Comments} wird an die entsprechende Tabelle gebunden, um die Einträge des Typs {@link I_CommentEntry} zu verwalten.
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

    public ToggleGroup _qualityRequirementToggleGroup1;
    public ToggleGroup _qualityRequirementToggleGroup2;
    public ToggleGroup _qualityRequirementToggleGroup3;
    public ToggleGroup _qualityRequirementToggleGroup4;
    public ToggleGroup _qualityRequirementToggleGroup5;
    public ToggleGroup _qualityRequirementToggleGroup6;
    public ToggleGroup _qualityRequirementToggleGroup7;
    public ToggleGroup _qualityRequirementToggleGroup8;
    public ToggleGroup _qualityRequirementToggleGroup9;
    public ToggleGroup _qualityRequirementToggleGroup10;
    public ToggleGroup _qualityRequirementToggleGroup11;
    public ToggleGroup _qualityRequirementToggleGroup12;
    public ToggleGroup _qualityRequirementToggleGroup13;
    public ToggleGroup _qualityRequirementToggleGroup14;
    public ToggleGroup _qualityRequirementToggleGroup15;
    public ToggleGroup _qualityRequirementToggleGroup16;
    public ToggleGroup _qualityRequirementToggleGroup17;
    public ToggleGroup _qualityRequirementToggleGroup18;
    public ToggleGroup _qualityRequirementToggleGroup19;
    public ToggleGroup _qualityRequirementToggleGroup20;
    public ToggleGroup _qualityRequirementToggleGroup21;
    public ToggleGroup _qualityRequirementToggleGroup22;
    public ToggleGroup _qualityRequirementToggleGroup23;
    public ToggleGroup _qualityRequirementToggleGroup24;
    public ToggleGroup _qualityRequirementToggleGroup25;
    public ToggleGroup _qualityRequirementToggleGroup26;
    public ToggleGroup _qualityRequirementToggleGroup27;
    public ToggleGroup _qualityRequirementToggleGroup28;

    public TableView<I_CommentEntry> _commentsTable;
    public Button _commentsAddButton;
    public Button _commentsEditButton;
    public Button _commentsDeleteButton;

    /**
     * Bindet die o.g. View-Elemente an ihre Model-Repräsentation.
     * Fügt jedem Textfeld eine Validierungsroutine hinzu. Für mehr Informationen yur Validierung, siehe {@link ValidateInput}.
     * Für mehr Informationen zur Bindung eines Models an eine Tabelle, siehe {@link I_TableBinding}.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _projectGoalText.textProperty().bindBidirectional(_dataModel.projectGoalProperty());
        new ValidateInput(_projectGoalText, Validator.PLAIN_TEXT);
        _fieldOfApplicationText.textProperty().bindBidirectional(_dataModel.fieldOfApplicationProperty());
        new ValidateInput(_fieldOfApplicationText, Validator.PLAIN_TEXT);

        I_TableBinding<I_FunctionalRequirementEntry> functionalRequirementEntryTableBinding = new TableBinding<>();
        functionalRequirementEntryTableBinding.setTableView(_functionalRequirementsTable);
        functionalRequirementEntryTableBinding.setDataModel(_dataModel.getFunctionalRequirements());
        functionalRequirementEntryTableBinding.bindTableToData();
        functionalRequirementEntryTableBinding.bindButtonsToTableActions(_functionalRequirementsAddButton,
                                                                         _functionalRequirementsEditButton,
                                                                         _functionalRequirementsDeleteButton
        );

        I_TableBinding<I_NonFunctionalRequirementEntry> nonFunctionalRequirementEntryTableBinding = new TableBinding<>();
        nonFunctionalRequirementEntryTableBinding.setTableView(_nonFunctionalRequirementsTable);
        nonFunctionalRequirementEntryTableBinding.setDataModel(_dataModel.getNonFunctionalRequirements());
        nonFunctionalRequirementEntryTableBinding.bindTableToData();
        nonFunctionalRequirementEntryTableBinding.bindButtonsToTableActions(_nonFunctionalRequirementsAddButton,
                                                                            _nonFunctionalRequirementsEditButton,
                                                                            _nonFunctionalRequirementsDeleteButton
        );

        ToggleGroup[] qualityRequirementToggleGroups = {_qualityRequirementToggleGroup1, _qualityRequirementToggleGroup2, _qualityRequirementToggleGroup3, _qualityRequirementToggleGroup4, _qualityRequirementToggleGroup5, _qualityRequirementToggleGroup6, _qualityRequirementToggleGroup7, _qualityRequirementToggleGroup8, _qualityRequirementToggleGroup9, _qualityRequirementToggleGroup10, _qualityRequirementToggleGroup11, _qualityRequirementToggleGroup12, _qualityRequirementToggleGroup13, _qualityRequirementToggleGroup14, _qualityRequirementToggleGroup15, _qualityRequirementToggleGroup16, _qualityRequirementToggleGroup17, _qualityRequirementToggleGroup18, _qualityRequirementToggleGroup19, _qualityRequirementToggleGroup20, _qualityRequirementToggleGroup21, _qualityRequirementToggleGroup22, _qualityRequirementToggleGroup23, _qualityRequirementToggleGroup24, _qualityRequirementToggleGroup25, _qualityRequirementToggleGroup26, _qualityRequirementToggleGroup27, _qualityRequirementToggleGroup28};
        for (int i = 0; i < qualityRequirementToggleGroups.length; i++) {
            ToggleGroup currentToggleGroup = qualityRequirementToggleGroups[i];
            I_QualityRequirementEntry currentQualityRequirementEntry = _dataModel.getQualityRequirementEntries().get(i);

            qualityRequirementToggleGroups[i].selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
                if (currentToggleGroup.getSelectedToggle() != null)
                    currentQualityRequirementEntry.setPriority(Priority.values()[Integer.parseInt(currentToggleGroup.getSelectedToggle()
                                                                                                                    .getUserData()
                                                                                                                    .toString())]);
            });

            currentQualityRequirementEntry.priorityProperty().addListener((observable, oldValue, newValue) -> {
                if (currentQualityRequirementEntry.getPriority() == Priority.UNSET) {
                    currentToggleGroup.selectToggle(null);
                } else {
                    currentToggleGroup.selectToggle(currentToggleGroup.getToggles()
                                                                      .get(currentQualityRequirementEntry.getPriority()
                                                                                                         .ordinal()));
                }
            });
        }

        I_TableBinding<I_CommentEntry> commentEntryTableBinding = new TableBinding<>();
        commentEntryTableBinding.setTableView(_commentsTable);
        commentEntryTableBinding.setDataModel(_dataModel.getComments());
        commentEntryTableBinding.bindTableToData();
        commentEntryTableBinding.bindButtonsToTableActions(_commentsAddButton,
                                                           _commentsEditButton,
                                                           _commentsDeleteButton
        );
    }
}
