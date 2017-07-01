package app.controller;

import app.Constants;
import app.Main;
import app.helpers.ValidateInput;
import app.helpers.ValidateInput.Validator;
import app.model.implementation.Project;
import app.model.interfaces.ProjectData.I_ProjectData;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller für die Projektdaten (view/projectData.fxml).
 * Jedes Textfeld wird an seine Model-Repräsentation gebunden und mit einer entsprechenden Validierung versehen.
 */
public class ProjectDataController implements Initializable {
    private final I_ProjectData _projectData = Project.getInstance().getProjectData();

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

    /**
     * Bindet die Textfelder an die Repräsentationen im Model.
     * Fügt jedem Textfeld eine Validierungsroutine hinzu. Für mehr Informationen yur Validierung, siehe {@link ValidateInput}.
     */
    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {


        //<editor-fold desc="Projekt-Eigenschaften">
        _projectName.textProperty().bindBidirectional(_projectData.nameProperty());
        new ValidateInput(_projectName, Validator.PLAIN_TEXT);

        /* Setzt den Fenstertitel gemäss des Projektnamens */
        _projectName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (_projectName.getText().isEmpty()) {
                Main.getPrimaryStage().setTitle(Constants.CONTEXT_TITLE_COMMON);
            } else {
                Main.getPrimaryStage()
                        .setTitle(Constants.CONTEXT_TITLE_COMMON + " - Projekt: " + _projectName.getText());
            }
        });

        _projectDueDate.textProperty().bindBidirectional(_projectData.dueDateProperty());
        new ValidateInput(_projectDueDate, Validator.DATE);
        //</editor-fold>

        //<editor-fold desc="Projekt-Bearbeiter">
        _editorName.textProperty()
                .bindBidirectional(_projectData.getProjectEditor()
                        .nameProperty());
        new ValidateInput(_editorName, Validator.PLAIN_TEXT);

        _editorSurname.textProperty()
                .bindBidirectional(_projectData.getProjectEditor()
                        .surnameProperty());
        new ValidateInput(_editorSurname, Validator.PLAIN_TEXT);
        //</editor-fold>

        //<editor-fold desc="Kundendaten">
        _customerSurname.textProperty().bindBidirectional(_projectData.getCustomer().surnameProperty());
        new ValidateInput(_customerSurname, Validator.PLAIN_TEXT);

        _customerName.textProperty().bindBidirectional(_projectData.getCustomer().nameProperty());
        new ValidateInput(_customerName, Validator.PLAIN_TEXT);

        _customerTelephone.textProperty().bindBidirectional(_projectData.getCustomer().telephoneProperty());
        new ValidateInput(_customerTelephone, Validator.PHONE_NUMBER);

        _customerEmail.textProperty().bindBidirectional(_projectData.getCustomer().emailProperty());
        new ValidateInput(_customerEmail, Validator.EMAIL);

        _customerCompanyName.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyNameProperty());
        new ValidateInput(_customerCompanyName, Validator.PLAIN_TEXT);

        _customerCompanyStreet.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyStreetProperty());
        new ValidateInput(_customerCompanyStreet, Validator.PLAIN_TEXT);

        _customerCompanyPlz.textProperty().bindBidirectional(_projectData.getCustomer().companyPLZProperty());
        new ValidateInput(_customerCompanyPlz, Validator.PLZ);


        _customerCompanyLocation.textProperty()
                .bindBidirectional(_projectData.getCustomer().companyLocationProperty());
        new ValidateInput(_customerCompanyLocation, Validator.PLAIN_TEXT);
        //</editor-fold>
    }
}
