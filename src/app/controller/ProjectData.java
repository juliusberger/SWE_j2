package app.controller;

import app.helpers.ValidateInput;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import app.model.implementation.Project;
import app.model.interfaces.ProjectData.I_ProjectData;

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
        //<editor-fold desc="Projekt-Eigenschaften">
        this.projectName.textProperty().bindBidirectional(this._projectData.nameProperty());

        this.projectDueDate.textProperty().bindBidirectional(this._projectData.dueDateProperty());
        this.projectDueDate.textProperty()
                .addListener((ov, oldValue, newValue) -> ValidateInput.validateDateField(this.projectDueDate));
        //</editor-fold>

        //<editor-fold desc="Projekt-Bearbeiter">
        this.editorName.textProperty()
                .bindBidirectional(this._projectData.getProjectEditor()
                        .nameProperty());
        this.editorSurname.textProperty()
                .bindBidirectional(this._projectData.getProjectEditor()
                        .surnameProperty());
        //</editor-fold>

        //<editor-fold desc="Kundendaten">
        this.customerSurname.textProperty().bindBidirectional(this._projectData.getCustomer().surnameProperty());
        this.customerName.textProperty().bindBidirectional(this._projectData.getCustomer().nameProperty());

        this.customerTelephone.textProperty().bindBidirectional(this._projectData.getCustomer().telephoneProperty());
        this.customerTelephone.textProperty()
                .addListener((ov, newValue, oldValue) -> ValidateInput.validatePhoneNumberField(this.customerTelephone));

        this.customerEmail.textProperty().bindBidirectional(this._projectData.getCustomer().emailProperty());
        this.customerEmail.textProperty()
                .addListener((observable, oldValue, newValue) -> ValidateInput.validateEmailField(this.customerEmail));

        this.customerCompanyName.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyNameProperty());
        this.customerCompanyStreet.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyStreetProperty());

        this.customerCompanyPLZ.textProperty().bindBidirectional(this._projectData.getCustomer().companyPLZProperty());
        this.customerCompanyPLZ.textProperty()
                .addListener((observable, oldValue, newValue) -> ValidateInput.validatePLZField(this.customerCompanyPLZ));


        this.customerCompanyLocation.textProperty()
                .bindBidirectional(this._projectData.getCustomer().companyLocationProperty());
        //</editor-fold>
    }
}
