package app.controller;


import app.helpers.I_TableBinding;
import app.helpers.TableBinding;
import app.model.implementation.Project;
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
 * Dieser Controller ist verantwortlich für die Erstellung des Klassifizierungs-Dialogs, ausgelöst durch den {@link CostEstimationController}.
 */
public class ClassificationController implements Initializable {
    private final I_Classification _dataModel = Project.getInstance().getClassification();
    private final I_FunctionalRequirements _functionalRequirements = Project.getInstance().getRequirements().getFunctionalRequirements();

    public TableView<I_ClassificationEntry> _classificationTable;
    public TableColumn<I_ClassificationEntry, String> _categoryColumn;
    public TableColumn<I_ClassificationEntry, String> _classificationColumn;
    public Button _classificationSaveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> categoryList = FXCollections.observableArrayList("Eingabedaten (EI)", "Ausgabedaten (EO)", "Abfragen (EQ)", "Datenbestände (ILF)", "Referenzdaten (ELF)");
        _categoryColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(categoryList));

        ObservableList<String> classificationList = FXCollections.observableArrayList("einfach", "mittel", "komplex");
        _classificationColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(classificationList));

        I_TableBinding classificationTableBinding = new TableBinding<>(_classificationTable, _dataModel);
        classificationTableBinding.bindTableToData();

        _classificationSaveButton.setOnAction(event -> ((Stage) _classificationSaveButton.getScene().getWindow()).close());


        for (int index = 0; index < _functionalRequirements.getEntries().size(); index++) {
            boolean duplicate = false;

            ArrayList<String> functionalRequirementEntry = _functionalRequirements.getEntries().get(index).getAllProperties();

            for (int h = 0; h < _dataModel.getEntries().size(); h++) {
                if (Objects.equals(functionalRequirementEntry.get(0), _dataModel.getEntries().get(h).getFunction())) {
                    duplicate = true;
                }
            }
            if (!duplicate) {
                _dataModel.addEntryWithProperties(functionalRequirementEntry);
            }
        }
    }


}
