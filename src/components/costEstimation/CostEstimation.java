package components.costEstimation;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import models.implementation.Project;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Julius on 26.04.17.
 */
public class CostEstimation implements Initializable {

    public Button classifyRequirementsButton;

    public ChoiceBox<String> box1;

    public Label calculatedFPLabel;
    public Label calculatedMMLabel;

    public Button manualOptimizationButton;
    public Button automaticOptimizationButton;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        this.box1.valueProperty()
                .bindBidirectional(Project.getInstance().getCostEstimationEntries().get(0).getWeightProperty());
        Project.getInstance()
                .getCostEstimationEntries()
                .get(0)
                .getWeightProperty()
                .addListener((observable, oldValue, newValue) -> System.out
                        .println(newValue));
    }
}
