package components.projectData;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Customer.Customer;
import models.ProjectData.I_ProjectData;
import models.ProjectEditor.ProjectEditor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 22/04/2017.
 */
public class ProjectData implements Initializable {

    public TextField projectName;
    public TextField projectDueDate;

    public TextField editorSurname;
    public TextField editorName;

    public TextField customerSurname;
    public TextField customerName;
    public TextField customerTelephone;
    public TextField customerEmail;

    public TextField customerCompanyName;
    public TextField customerCompanyStreet;
    public TextField customerCompanyPLZ;
    public TextField customerCompanyLocation;

    private I_ProjectData IProjectData = new models.ProjectData.ProjectData("",
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

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        this.projectName.textProperty().bindBidirectional(this.IProjectData.nameProperty());
        this.projectDueDate.textProperty().bindBidirectional(this.IProjectData.dueDateProperty());


        this.editorName.textProperty()
                .bindBidirectional(this.IProjectData.getProjectEditor()
                        .nameProperty());
        this.editorSurname.textProperty()
                .bindBidirectional(this.IProjectData.getProjectEditor()
                        .surnameProperty());

        this.customerSurname.textProperty().bindBidirectional(this.IProjectData.getCustomer().surnameProperty());
        this.customerName.textProperty().bindBidirectional(this.IProjectData.getCustomer().nameProperty());
        this.customerTelephone.textProperty().bindBidirectional(this.IProjectData.getCustomer().telephoneProperty());
        this.customerEmail.textProperty().bindBidirectional(this.IProjectData.getCustomer().emailProperty());

        this.customerCompanyName.textProperty()
                .bindBidirectional(this.IProjectData.getCustomer().companyNameProperty());
        this.customerCompanyStreet.textProperty()
                .bindBidirectional(this.IProjectData.getCustomer().companyStreetProperty());
        this.customerCompanyPLZ.textProperty().bindBidirectional(this.IProjectData.getCustomer().companyPLZProperty());
        this.customerCompanyLocation.textProperty()
                .bindBidirectional(this.IProjectData.getCustomer().companyLocationProperty());
    }
}
