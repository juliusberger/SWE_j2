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

    public Button classifyRequirementsButton;

    public ChoiceBox<String> box1;
    public ChoiceBox<String> box2;
    public ChoiceBox<String> box3;
    public ChoiceBox<String> box4a;
    public ChoiceBox<String> box4b;
    public ChoiceBox<String> box4c;
    public ChoiceBox<String> box4d;
    public ChoiceBox<String> box5;
    public ChoiceBox<String> box6;
    public ChoiceBox<String> box7;

    public Label calculatedFPLabel;
    public Label calculatedMMLabel;

    public Button manualOptimizationButton;
    public Button automaticOptimizationButton;


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        this.box1.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(0)
                        .getWeightProperty());
        this.box2.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(1)
                        .getWeightProperty());
        this.box3.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(2)
                        .getWeightProperty());
        this.box4a.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(3)
                        .getWeightProperty());
        this.box4b.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(3)
                        .getWeightProperty());
        this.box4c.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(3)
                        .getWeightProperty());
        this.box4d.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(3)
                        .getWeightProperty());
        this.box5.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(4)
                        .getWeightProperty());
        this.box6.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(5)
                        .getWeightProperty());
        this.box7.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(6)
                        .getWeightProperty());

        classifyRequirementsButton.setOnAction(event -> {
            Classification classification = new Classification();
            classification.show();
        });
    }
}
