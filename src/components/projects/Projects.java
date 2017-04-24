package components.projects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Project.Project;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 22/04/2017.
 */
public class Projects implements Initializable {

    public TableView<Project> projectsTable;
    public TableColumn<Project, String> nameColumn;
    public TableColumn<Project, String> dateCreatedColumn;
    public TableColumn<Project, String> dateModifiedColumn;

    public Button loadProjectButton;

    // debug
    private ObservableList<Project> tData = FXCollections.observableArrayList(
            new Project("Test1",
                    "22.04.2017",
                    "22.04.2017",
                    "",
                    null),
            new Project("Test2",
                    "23.04.2017",
                    "22.04.2017",
                    "",
                    null),
            new Project("Test3",
                    "22.04.2017",
                    "24.04.2017",
                    "",
                    null)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //<editor-fold desc="Tabelle mit Model verknüpfen">
//        TableBinding.bindTableToData(projectsTable,
//                tData,
//                "name",
//                "dateCreated",
//                "dateModified");

//        nameColumn.setCellValueFactory(
//                new PropertyValueFactory<>("name")
//        );
//        dateCreatedColumn.setCellValueFactory(
//                new PropertyValueFactory<>("dateCreated")
//        );
//        dateModifiedColumn.setCellValueFactory(
//                new PropertyValueFactory<>("dateModified")
//        );
//
//        projectsTable.setItems(tData);
        //</editor-fold>

//        TableBinding.observeDisabledButtonState(projectsTable,
//                loadProjectButton);
        //<editor-fold desc="'Projekt laden' Button Aktivieren, wenn Auswahl in Tabelle erfolgt">
//        projectsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                loadProjectButton.setDisable(false);
//            } else {
//                loadProjectButton.setDisable(true);
//            }
//        });
        //</editor-fold>
    }

    /**
     * Wenn 'Projekt laden' Button betätigt
     */
    public void loadProject() {
        Project selectedProject = this.projectsTable.getSelectionModel().getSelectedItem();
        // TODO: handle project load

        // debug
        System.out.println("Ausgewählt: " + selectedProject.getName());
    }

}
