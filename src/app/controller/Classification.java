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
import java.util.Observable;

/**
 * Created by Matthias on 24.06.2017.
 */
public class Classification extends Observable {

    private Stage _stage = new Stage();
    private boolean _saveClicked = false;

    private TableView<I_ClassificationEntry> _tableView = new TableView<I_ClassificationEntry>();

    private I_Classification _dataModel = Project.getInstance().getClassification();

    private I_FunctionalRequirements functionalRequirements = Project.getInstance().getRequirements().getFunctionalRequirements();

    public final ArrayList<String> categoryArrayList = new ArrayList<>();
    public final ArrayList<String> classificationArrayList = new ArrayList<>();

    public Classification() {

        _stage.initModality(Modality.APPLICATION_MODAL);
        _stage.initStyle(StageStyle.DECORATED);
        _stage.setTitle("Anforderungen klassifizieren");
        _stage.getIcons().add(new Image(getClass().getResourceAsStream("../assets/ANTool_Icon2.png")));

        final VBox vBox = new VBox();

        vBox.setSpacing(10.0);
        vBox.getStylesheets().add(getClass().getResource("../assets/global.css").toExternalForm());
        vBox.getStyleClass().add("p-10");
        vBox.setPrefWidth(700);

        {
            TableColumn _function = new TableColumn("Funktion");
            TableColumn _description = new TableColumn("Beschreibung");
            TableColumn _stakeholder = new TableColumn("Akteur");
            TableColumn _category = new TableColumn("Kategorie");
            TableColumn _classification = new TableColumn("Klassifizierung");

            _tableView.getStyleClass().add("h3");
            _tableView.setMaxHeight(360.0);

            ObservableList<String> categoryList = FXCollections.observableArrayList("Eingabedaten (EI)", "Ausgabedaten (EO)", "Abfragen (EQ)", "Datenbestände (ILF)", "Referenzdaten (ELF)");
            _category.setCellFactory(ChoiceBoxTableCell.forTableColumn(categoryList));

            ObservableList<String> classificationList = FXCollections.observableArrayList("einfach", "mittel", "komplex");
            _classification.setCellFactory(ChoiceBoxTableCell.forTableColumn(classificationList));

            _tableView.getColumns().addAll(_function, _description, _stakeholder, _category, _classification);
            _tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

            _tableView.setEditable(true);

            int i = 0;
            for (String propertyName : _dataModel.getPropertyNames()) {
                _tableView.getColumns()
                        .get(i++)
                        .setCellValueFactory(new PropertyValueFactory<>(propertyName));
            }

            //Bind Table to _dataModel

            _dataModel.removeExistingData();

            if (categoryArrayList.size() != functionalRequirements.getEntries().size()){

                categoryArrayList.clear();
                classificationArrayList.clear();

                for (int index = 0; index < functionalRequirements.getEntries().size(); index++) {
                    categoryArrayList.add("");
                    classificationArrayList.add("");
                }
            }

            for (int index = 0; index < functionalRequirements.getEntries().size(); index++) {

                ArrayList<String> functionalRequirementEntry = functionalRequirements.getEntries().get(index).getAllProperties();

                _dataModel.addEntryWithProperties(functionalRequirementEntry);

                _dataModel.getEntries().get(index).setCategory(categoryArrayList.get(index));
                _dataModel.getEntries().get(index).setClassification(classificationArrayList.get(index));
            }

            _tableView.setItems(_dataModel.getEntries());

            _tableView.setEditable(true);

            vBox.getChildren().add(_tableView);
        }

        {
            Button saveButton = new Button("Speichern");
            Button cancelButton = new Button("Abbrechen");
            saveButton.setOnAction(event -> save());
            cancelButton.setOnAction(event -> close());
            saveButton.setMaxWidth(1.7976931348623157E308);
            cancelButton.setMaxWidth(1.7976931348623157E308);
            HBox.setHgrow(saveButton,
                    Priority.ALWAYS);
            HBox.setHgrow(cancelButton,
                    Priority.ALWAYS);

            HBox buttonBox = new HBox();
            buttonBox.getStyleClass().add("button-hbox");

            buttonBox.getChildren()
                    .addAll(saveButton,
                            cancelButton);

            vBox.getChildren().add(buttonBox);
        }

        _stage.setScene(new Scene(vBox));
    }

    private void save() {

        for (int index = 0; index < functionalRequirements.getEntries().size(); index++) {

            //categoryArrayList.set(index, _dataModel.getEntries().get(index).getCategory());
            categoryArrayList.set(index, _tableView.getItems().get(index).getCategory());
            classificationArrayList.set(index, _tableView.getItems().get(index).getClassification());
        }

        _saveClicked = true;
        close();
    }

    private void close() {
        _stage.close();
        setChanged();
        notifyObservers();
    }

    boolean isSaveClicked() {
        return _saveClicked;
    }

    void show() {
        _stage.showAndWait();
    }
}
