package components.projects;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    public Button loadProject;


    private ObservableList<Project> tData = FXCollections.observableArrayList(
            new Project("Test1", "22.04.2017", "22.04.2017"),
            new Project("Test2", "23.04.2017", "22.04.2017"),
            new Project("Test3", "22.04.2017", "24.04.2017")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        dateCreatedColumn.setCellValueFactory(
                new PropertyValueFactory<>("dateCreated")
        );
        dateModifiedColumn.setCellValueFactory(
                new PropertyValueFactory<>("dateModified")
        );

        projectsTable.setItems(tData);
    }

    public void loadProject() {
        Project selectedProject = projectsTable.getSelectionModel().getSelectedItem();
        // TODO: handle project load

        // debug
        System.out.println("Ausgewählt: " + selectedProject.getName());
    }

    // TODO: To be moved to models
    public static class Project {
        private final SimpleStringProperty name;
        private final SimpleStringProperty dateCreated;
        private final SimpleStringProperty dateModified;

        private Project(String name, String dateCreated, String dateModified) {
            this.name = new SimpleStringProperty(name);
            this.dateCreated = new SimpleStringProperty(dateCreated);
            this.dateModified = new SimpleStringProperty(dateModified);
        }

        private String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getDateCreated() {
            return dateCreated.get();
        }

        public SimpleStringProperty dateCreatedProperty() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated.set(dateCreated);
        }

        public String getDateModified() {
            return dateModified.get();
        }

        public SimpleStringProperty dateModifiedProperty() {
            return dateModified;
        }

        public void setDateModified(String dateModified) {
            this.dateModified.set(dateModified);
        }
    }
}
