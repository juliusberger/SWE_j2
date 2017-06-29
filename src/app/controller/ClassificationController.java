package app.controller;


import app.helpers.I_TableBinding;
import app.helpers.InfoDialog;
import app.helpers.TableBinding;
import app.model.implementation.Project;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.Requirements.I_FunctionalRequirements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Created by Matthias on 24.06.2017.
 */
public class ClassificationController implements Initializable {
    public TableView<I_ClassificationEntry> _classificationTable;

    public TableColumn<I_ClassificationEntry, String> _categoryColumn;
    public TableColumn<I_ClassificationEntry, String> _classificationColumn;

    public Button _classificationSaveButton;

    private I_Classification _dataModel = Project.getInstance().getClassification();
    private I_FunctionalRequirements _functionalRequirements = Project.getInstance().getRequirements().getFunctionalRequirements();

    static void showClassificationDialog() {
        final Stage stage = new Stage();

        try {
            VBox vBox = FXMLLoader.load(ClassificationController.class.getResource("../view/classification.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Anforderungen klassifizieren");
            stage.getIcons().add(new Image(ClassificationController.class.getResourceAsStream("../assets/ANTool_Icon2.png")));
            stage.setScene(new Scene(vBox));

            stage.showAndWait();
        } catch (IOException e) {
            InfoDialog.show("Fehler", "Programmfehler", "Beim Erstellen der Klassifikation ist ein Fehler aufgetreten.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> _categoryList = FXCollections.observableArrayList("Eingabedaten (EI)", "Ausgabedaten (EO)", "Abfragen (EQ)", "Datenbestände (ILF)", "Referenzdaten (ELF)");
        _categoryColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(_categoryList));

        ObservableList<String> _classificationList = FXCollections.observableArrayList("einfach", "mittel", "komplex");
        _classificationColumn.setCellFactory(ChoiceBoxTableCell.forTableColumn(_classificationList));

        I_TableBinding classificationTableBinding = new TableBinding<>(_classificationTable, _dataModel);
        classificationTableBinding.bindTableToData();

        _classificationSaveButton.setOnAction(event -> ((Stage) _classificationSaveButton.getScene().getWindow()).close());


        for (int index = 0; index < _functionalRequirements.getEntries().size(); index++) {
            boolean _duplicate = false;

            ArrayList<String> functionalRequirementEntry = _functionalRequirements.getEntries().get(index).getAllProperties();

            for (int h = 0; h < _dataModel.getEntries().size(); h++) {
                if (Objects.equals(functionalRequirementEntry.get(0), _dataModel.getEntries().get(h).getFunction())) {
                    _duplicate = true;
                }
            }
            if (!_duplicate) {
                _dataModel.addEntryWithProperties(functionalRequirementEntry);
            }
        }
    }


}
