package app.controller;


import app.components.tableBinding.I_TableBinding;
import app.components.tableBinding.TableBinding;
import app.model.implementation.ProjectRegistry;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.Requirements.I_FunctionalRequirements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller für die Klassifizierung (view/classification.fxml).
 * Dieser Controller ist verantwortlich für die Erstellung und Anzeige des Klassifizierungs-Dialogs, ausgelöst durch den {@link CostEstimationController}.
 */
public class ClassificationController implements Initializable {
    private final I_Classification _dataModel = ProjectRegistry.getInstance().getClassification();
    private final I_FunctionalRequirements _functionalRequirements = ProjectRegistry.getInstance()
                                                                                    .getRequirements()
                                                                                    .getFunctionalRequirements();

    public TableView<I_ClassificationEntry> _classificationTable;
    public TableColumn<I_ClassificationEntry, String> _categoryColumn;
    public TableColumn<I_ClassificationEntry, String> _classificationColumn;
    public Button _classificationSaveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> categoryList = FXCollections.observableArrayList(
                "Eingabedaten (EI)",
                "Ausgabedaten (EO)",
                "Abfragen (EQ)",
                "Datenbestände (ILF)",
                "Referenzdaten (ELF)"
        );
        _categoryColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(categoryList));

        ObservableList<String> classificationList = FXCollections.observableArrayList("einfach", "mittel", "komplex");
        _classificationColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(classificationList));

        I_TableBinding<I_ClassificationEntry> classificationTableBinding = new TableBinding<>();
        classificationTableBinding.setTableView(_classificationTable);
        classificationTableBinding.setDataModel(_dataModel);
        classificationTableBinding.bindTableToData();

        _classificationSaveButton.setOnAction(event -> ((Stage) _classificationSaveButton.getScene()
                                                                                         .getWindow()).close());


        for (int indexFunctionalRequirements = 0; indexFunctionalRequirements < _functionalRequirements.getEntries().size(); indexFunctionalRequirements++) {
            boolean duplicate = false;

            ArrayList<String> functionalRequirementEntry = _functionalRequirements.getEntries()
                                                                                  .get(indexFunctionalRequirements)
                                                                                  .getAllProperties();

            for (int indexDataModel = 0; indexDataModel < _dataModel.getEntries().size(); indexDataModel++) {
                if (Objects.equals(functionalRequirementEntry.get(0), _dataModel.getEntries().get(indexDataModel).getFunction()) &&
                        Objects.equals(functionalRequirementEntry.get(1), _dataModel.getEntries().get(indexDataModel).getDescription()) &&
                        Objects.equals(functionalRequirementEntry.get(2), _dataModel.getEntries().get(indexDataModel).getStakeholder())) {
                    duplicate = true;
                }
            }
            if (!duplicate) {
                _dataModel.addEntryWithProperties(functionalRequirementEntry);
            }
        }

        for (int indexDataModel = 0; indexDataModel < _dataModel.getEntries().size(); indexDataModel++) {
            boolean included = false;

            for (int functionalRequirementEntry = 0; functionalRequirementEntry < _functionalRequirements.getEntries().size(); functionalRequirementEntry++) {
                if (Objects.equals(_dataModel.getEntries().get(indexDataModel).getFunction(), _functionalRequirements.getEntries().get(functionalRequirementEntry).getAllProperties().get(0)) &&
                        Objects.equals(_dataModel.getEntries().get(indexDataModel).getDescription(), _functionalRequirements.getEntries().get(functionalRequirementEntry).getAllProperties().get(1)) &&
                        Objects.equals(_dataModel.getEntries().get(indexDataModel).getStakeholder(), _functionalRequirements.getEntries().get(functionalRequirementEntry).getAllProperties().get(2))) {
                    included = true;
                }
            }
            if (!included) _dataModel.getEntries().remove(indexDataModel);
        }

    }


}
