package components.projectData;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Customer.Customer;
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

    private models.ProjectData.ProjectData projectData = new models.ProjectData.ProjectData("",
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
        this.projectName.textProperty().bindBidirectional(this.projectData.nameProperty());
        this.projectDueDate.textProperty().bindBidirectional(this.projectData.dueDateProperty());


        this.editorName.textProperty()
                .bindBidirectional(this.projectData.getProjectEditor()
                        .nameProperty());
        this.editorSurname.textProperty()
                .bindBidirectional(this.projectData.getProjectEditor()
                        .surnameProperty());

        this.customerSurname.textProperty().bindBidirectional(this.projectData.getCustomer().surnameProperty());
        this.customerName.textProperty().bindBidirectional(this.projectData.getCustomer().nameProperty());
        this.customerTelephone.textProperty().bindBidirectional(this.projectData.getCustomer().telephoneProperty());
        this.customerEmail.textProperty().bindBidirectional(this.projectData.getCustomer().emailProperty());

        this.customerCompanyName.textProperty().bindBidirectional(this.projectData.getCustomer().companyNameProperty());
        this.customerCompanyStreet.textProperty()
                .bindBidirectional(this.projectData.getCustomer().companyStreetProperty());
        this.customerCompanyPLZ.textProperty().bindBidirectional(this.projectData.getCustomer().companyPLZProperty());
        this.customerCompanyLocation.textProperty()
                .bindBidirectional(this.projectData.getCustomer().companyLocationProperty());
    }
}
