package components.projectData;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Customer.Customer;
import models.ProjectEditor.ProjectEditor;

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

    private models.ProjectData.ProjectData projectData;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources)
    {
        this.projectData = new models.ProjectData.ProjectData("",
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

        this.editorName.textProperty()
                .bindBidirectional(this.projectData.getProjectEditor()
                        .nameProperty());
        this.editorSurname.textProperty()
                .bindBidirectional(this.projectData.getProjectEditor()
                        .surnameProperty());
    }
}
