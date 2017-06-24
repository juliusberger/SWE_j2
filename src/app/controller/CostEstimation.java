package app.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import app.model.implementation.Project;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Julius on 26.04.17.
 */
public class CostEstimation implements Initializable {

    public Button _classifyRequirementsButton;

    public ChoiceBox<String> _box1;
    public ChoiceBox<String> _box2;
    public ChoiceBox<String> _box3;
    public ChoiceBox<String> _box4a;
    public ChoiceBox<String> _box4b;
    public ChoiceBox<String> _box4c;
    public ChoiceBox<String> _box4d;
    public ChoiceBox<String> _box5;
    public ChoiceBox<String> _box6;
    public ChoiceBox<String> _box7;

    public Label _calculatedFPLabel;
    public Label _calculatedMMLabel;

    public Button _manualOptimizationButton;
    public Button _automaticOptimizationButton;


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        _box1.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(0)
                        .getWeightProperty());
        _box2.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(1)
                        .getWeightProperty());
        _box3.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(2)
                        .getWeightProperty());
        _box4a.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(3)
                        .getWeightProperty());
        _box4b.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(4)
                        .getWeightProperty());
        _box4c.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(5)
                        .getWeightProperty());
        _box4d.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(6)
                        .getWeightProperty());
        _box5.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(7)
                        .getWeightProperty());
        _box6.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(8)
                        .getWeightProperty());
        _box7.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(9)
                        .getWeightProperty());

        _classifyRequirementsButton.setOnAction(event -> {
            Classification classification = new Classification();
            classification.show();
        });
    }
}
