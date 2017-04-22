package components.projectData;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Customer;
import models.ProjectEditor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 22/04/2017.
 */
public class ProjectData implements Initializable
{

    public TextField editorSurname;
    public TextField editorName;

    public Button debug;

    private models.ProjectData projectData;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources)
    {
        projectData = new models.ProjectData("",
                "",
                new ProjectEditor("",
                        ""),
                new Customer("",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""));

        editorName.textProperty()
                .bindBidirectional(projectData.getProjectEditor()
                        .nameProperty());
        editorSurname.textProperty()
                .bindBidirectional(projectData.getProjectEditor()
                        .surnameProperty());
    }
}
