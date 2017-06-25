package app.controller;

import app.helpers.ValidateInput;
import app.helpers.ValidateInput.Validator;
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

    public TextField _projectName;
    public TextField _projectDueDate;

    public TextField _editorSurname;
    public TextField _editorName;

    public TextField _customerSurname;
    public TextField _customerName;
    public TextField _customerTelephone;
    public TextField _customerEmail;

    public TextField _customerCompanyName;
    public TextField _customerCompanyStreet;
    public TextField _customerCompanyPlz;
    public TextField _customerCompanyLocation;

    private final I_ProjectData _projectData = Project.getInstance().getProjectData();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        //<editor-fold desc="Projekt-Eigenschaften">
        _projectName.textProperty().bindBidirectional(_projectData.nameProperty());
        ValidateInput.addValidator(_projectName, Validator.PLAIN_TEXT);

        _projectDueDate.textProperty().bindBidirectional(_projectData.dueDateProperty());
        ValidateInput.addValidator(_projectDueDate, Validator.DATE);
        //</editor-fold>

        //<editor-fold desc="Projekt-Bearbeiter">
        _editorName.textProperty()
                .bindBidirectional(_projectData.getProjectEditor()
                        .nameProperty());
        ValidateInput.addValidator(_editorName, Validator.PLAIN_TEXT);

        _editorSurname.textProperty()
                .bindBidirectional(_projectData.getProjectEditor()
                        .surnameProperty());
        ValidateInput.addValidator(_editorSurname, Validator.PLAIN_TEXT);
        //</editor-fold>

        //<editor-fold desc="Kundendaten">
        _customerSurname.textProperty().bindBidirectional(_projectData.getCustomer().surnameProperty());
        ValidateInput.addValidator(_customerSurname, Validator.PLAIN_TEXT);

        _customerName.textProperty().bindBidirectional(_projectData.getCustomer().nameProperty());
        ValidateInput.addValidator(_customerName, Validator.PLAIN_TEXT);

        _customerTelephone.textProperty().bindBidirectional(_projectData.getCustomer().telephoneProperty());
        ValidateInput.addValidator(_customerTelephone, Validator.PHONE_NUMBER);

        _customerEmail.textProperty().bindBidirectional(_projectData.getCustomer().emailProperty());
        ValidateInput.addValidator(_customerEmail, Validator.EMAIL);

        _customerCompanyName.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyNameProperty());
        ValidateInput.addValidator(_customerCompanyName, Validator.PLAIN_TEXT);

        _customerCompanyStreet.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyStreetProperty());
        ValidateInput.addValidator(_customerCompanyStreet, Validator.PLAIN_TEXT);

        _customerCompanyPlz.textProperty().bindBidirectional(_projectData.getCustomer().companyPLZProperty());
        ValidateInput.addValidator(_customerCompanyPlz, Validator.PLZ);


        _customerCompanyLocation.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyLocationProperty());
        ValidateInput.addValidator(_customerCompanyLocation, Validator.PLAIN_TEXT);
        //</editor-fold>
    }
}
