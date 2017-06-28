package app.controller;


import app.model.implementation.Project;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.Requirements.I_FunctionalRequirements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

/**
 * Created by Matthias on 24.06.2017.
 */
public class Classification extends Observable {

    private Stage _stage = new Stage();

    private TableView<I_ClassificationEntry> _tableView = new TableView<I_ClassificationEntry>();

    private I_Classification _dataModel = Project.getInstance().getClassification();

    private I_FunctionalRequirements _functionalRequirements = Project.getInstance().getRequirements().getFunctionalRequirements();

    public Classification() {

        _stage.initModality(Modality.APPLICATION_MODAL);
        _stage.initStyle(StageStyle.DECORATED);
        _stage.setTitle("Anforderungen klassifizieren");
        _stage.getIcons().add(new Image(getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

        final VBox _vBox = new VBox();

        _vBox.setSpacing(10.0);
        _vBox.getStylesheets().add(getClass().getResource("../assets/global.css").toExternalForm());
        _vBox.getStyleClass().add("p-10");
        _vBox.setPrefWidth(700);

        {
            TableColumn _function = new TableColumn("Funktion");
            TableColumn _description = new TableColumn("Beschreibung");
            TableColumn _stakeholder = new TableColumn("Akteur");
            TableColumn _category = new TableColumn("Kategorie");
            TableColumn _classification = new TableColumn("Klassifizierung");

            _tableView.setMaxHeight(360.0);

            ObservableList<String> _categoryList = FXCollections.observableArrayList("Eingabedaten (EI)", "Ausgabedaten (EO)", "Abfragen (EQ)", "Datenbestände (ILF)", "Referenzdaten (ELF)");
            _category.setCellFactory(ChoiceBoxTableCell.forTableColumn(_categoryList));

            ObservableList<String> _classificationList = FXCollections.observableArrayList("einfach", "mittel", "komplex");
            _classification.setCellFactory(ChoiceBoxTableCell.forTableColumn(_classificationList));

            _tableView.getColumns().addAll(_function, _description, _stakeholder, _category, _classification);
            _tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            _tableView.setEditable(true);

            //Bind Table to _dataModel

            int i = 0;
            for (String propertyName : _dataModel.getPropertyNames()) {
                _tableView.getColumns()
                        .get(i++)
                        .setCellValueFactory(new PropertyValueFactory<>(propertyName));
            }

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

            _tableView.setItems(_dataModel.getEntries());

            _tableView.setEditable(true);

            _vBox.getChildren().add(_tableView);
        }

        {
            Button _saveButton = new Button("Speichern");
            _saveButton.setOnAction(event -> save());
            _saveButton.setMaxWidth(1.7976931348623157E308);
            HBox.setHgrow(_saveButton,
                    Priority.ALWAYS);
            HBox _buttonBox = new HBox();
            _buttonBox.getStyleClass().add("button-hbox");

            _buttonBox.getChildren()
                    .addAll(_saveButton);

            _vBox.getChildren().add(_buttonBox);
        }

        _stage.setScene(new Scene(_vBox));
    }

    private void save() {
        _stage.close();
        setChanged();
        notifyObservers();
    }

    void show() {
        _stage.showAndWait();
    }
}
