package app.controller;

import app.Constants;
import app.InfoDialog;
import app.InfoDialog.AlertType;
import app.Log;
import app.components.CostEstimationCalculation;
import app.components.I_CostEstimationCalculation;
import app.model.implementation.ProjectRegistry;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Julius on 26.04.17.
 */
public class CostEstimationController implements Initializable {
    public Button _classifyRequirementsButton;

    public ChoiceBox<String> _influenceFactorBox1;
    public ChoiceBox<String> _influenceFactorBox2;
    public ChoiceBox<String> _influenceFactorBox3;
    public ChoiceBox<String> _influenceFactorBox4a;
    public ChoiceBox<String> _influenceFactorBox4b;
    public ChoiceBox<String> _influenceFactorBox4c;
    public ChoiceBox<String> _influenceFactorBox4d;
    public ChoiceBox<String> _influenceFactorBox5;
    public ChoiceBox<String> _influenceFactorBox6;
    public ChoiceBox<String> _influenceFactorBox7;

    public Button _performCostEstimationButton;

    public Label _calculatedFunctionPointsLabel;
    public Label _calculatedMenMonthsLabel;

    public Button _manualOptimizationButton;
    public Button _automaticOptimizationButton;

    private I_CostEstimationCalculation _costEstimationCalculation;

    /**
     * Erstellt ein neues Fenster für den Klassifizierungs-Dialog und zeigt es an.
     * Durch showAndWait wird sichergestellt, dass der aufrufende Controller so lange blockiert, bis die Daten eingegeben und das Fenster geschlossen ist.
     */
    static void showClassificationDialog() {
        Stage stage = new Stage();

        try {
            VBox vBox = FXMLLoader.load(ClassificationController.class.getResource("../view/classification.fxml"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Anforderungen klassifizieren");
            stage.getIcons()
                 .add(new Image(ClassificationController.class.getResourceAsStream("../assets/ANTool_Icon2.png")));
            stage.setScene(new Scene(vBox));

            stage.showAndWait();
        } catch (IOException e) {
            Log.getLogger().log(
                    Level.SEVERE,
                    "Fehler beim Erstellen des Klassifizierungs-Dialogs: " + Arrays.toString(e.getStackTrace())
            );
            new InfoDialog(
                    Constants.CONTEXT_TITLE_ERROR,
                    "Programmfehler",
                    "Beim Erstellen der Klassifikation ist ein Fehler aufgetreten.",
                    AlertType.ERROR
            );
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _influenceFactorBox1.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(0)
                                                              .getWeightProperty());
        _influenceFactorBox2.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(1)
                                                              .getWeightProperty());
        _influenceFactorBox3.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(2)
                                                              .getWeightProperty());
        _influenceFactorBox4a.valueProperty()
                             .bindBidirectional(ProjectRegistry.getInstance()
                                                               .getCostEstimation()
                                                               .getCostEstimationEntries()
                                                               .get(3)
                                                               .getWeightProperty());
        _influenceFactorBox4b.valueProperty()
                             .bindBidirectional(ProjectRegistry.getInstance()
                                                               .getCostEstimation()
                                                               .getCostEstimationEntries()
                                                               .get(4)
                                                               .getWeightProperty());
        _influenceFactorBox4c.valueProperty()
                             .bindBidirectional(ProjectRegistry.getInstance()
                                                               .getCostEstimation()
                                                               .getCostEstimationEntries()
                                                               .get(5)
                                                               .getWeightProperty());
        _influenceFactorBox4d.valueProperty()
                             .bindBidirectional(ProjectRegistry.getInstance()
                                                               .getCostEstimation()
                                                               .getCostEstimationEntries()
                                                               .get(6)
                                                               .getWeightProperty());
        _influenceFactorBox5.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(7)
                                                              .getWeightProperty());
        _influenceFactorBox6.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(8)
                                                              .getWeightProperty());
        _influenceFactorBox7.valueProperty()
                            .bindBidirectional(ProjectRegistry.getInstance()
                                                              .getCostEstimation()
                                                              .getCostEstimationEntries()
                                                              .get(9)
                                                              .getWeightProperty());

        _classifyRequirementsButton.setOnAction(event -> showClassificationDialog());

        _performCostEstimationButton.setOnAction(event -> {
            _costEstimationCalculation = new CostEstimationCalculation(
                    _influenceFactorBox1.getValue(),
                    _influenceFactorBox2.getValue(),
                    _influenceFactorBox3.getValue(),
                    _influenceFactorBox4a.getValue(),
                    _influenceFactorBox4b.getValue(),
                    _influenceFactorBox4c.getValue(),
                    _influenceFactorBox4d.getValue(),
                    _influenceFactorBox5.getValue(),
                    _influenceFactorBox6.getValue(),
                    _influenceFactorBox7.getValue()
            );

            updateCalculationLabels();
        });

        _manualOptimizationButton.setOnAction(event -> {
            showClassificationDialog();

            updateCalculationLabels();
        });

        _automaticOptimizationButton.setOnAction(event -> {
            _costEstimationCalculation.performAutomaticOptimization();

            _influenceFactorBox1.setValue(_costEstimationCalculation.getInfluenceFactors().get("1"));
            _influenceFactorBox2.setValue(_costEstimationCalculation.getInfluenceFactors().get("2"));
            _influenceFactorBox3.setValue(_costEstimationCalculation.getInfluenceFactors().get("3"));
            _influenceFactorBox4a.setValue(_costEstimationCalculation.getInfluenceFactors().get("4a"));
            _influenceFactorBox4b.setValue(_costEstimationCalculation.getInfluenceFactors().get("4b"));
            _influenceFactorBox4c.setValue(_costEstimationCalculation.getInfluenceFactors().get("4c"));
            _influenceFactorBox4d.setValue(_costEstimationCalculation.getInfluenceFactors().get("4d"));
            _influenceFactorBox5.setValue(_costEstimationCalculation.getInfluenceFactors().get("5"));
            _influenceFactorBox6.setValue(_costEstimationCalculation.getInfluenceFactors().get("6"));
            _influenceFactorBox7.setValue(_costEstimationCalculation.getInfluenceFactors().get("7"));

            updateCalculationLabels();
        });
    }

    private void updateCalculationLabels() {
        _costEstimationCalculation.performCostEstimation();
        _calculatedFunctionPointsLabel.setText(Double.toString(_costEstimationCalculation.getCalculatedFunctionPoints()));
        _calculatedMenMonthsLabel.setText(Double.toString(_costEstimationCalculation.getCalculatedMenMonths()));
    }


}
