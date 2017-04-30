package components.costEstimation;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Julius on 26.04.17.
 */
public class CostEstimation implements Initializable {

    public Button classifyRequirementsButton;

    public Label calculatedFPLabel;
    public Label calculatedMMLabel;

    public Button manualOptimizationButton;
    public Button automaticOptimizationButton;

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

    }
}
