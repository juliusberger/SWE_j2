package components.projectData;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.implementation.Project;
import models.interfaces.ProjectData.I_ProjectData;

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

    private final I_ProjectData _projectData = Project.getInstance().getProjectData();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        this.projectName.textProperty().bindBidirectional(this._projectData.nameProperty());
        this.projectDueDate.textProperty().bindBidirectional(this._projectData.dueDateProperty());


        this.editorName.textProperty()
                .bindBidirectional(this._projectData.getProjectEditor()
                        .nameProperty());
        this.editorSurname.textProperty()
                .bindBidirectional(this._projectData.getProjectEditor()
                        .surnameProperty());

        this.customerSurname.textProperty().bindBidirectional(this._projectData.getCustomer().surnameProperty());
        this.customerName.textProperty().bindBidirectional(this._projectData.getCustomer().nameProperty());
        this.customerTelephone.textProperty().bindBidirectional(this._projectData.getCustomer().telephoneProperty());
        this.customerEmail.textProperty().bindBidirectional(this._projectData.getCustomer().emailProperty());

        this.customerCompanyName.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyNameProperty());
        this.customerCompanyStreet.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyStreetProperty());
        this.customerCompanyPLZ.textProperty().bindBidirectional(this._projectData.getCustomer().companyPLZProperty());
        this.customerCompanyLocation.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyLocationProperty());
    }
}
