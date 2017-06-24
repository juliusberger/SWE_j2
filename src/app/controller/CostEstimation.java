package app.controller;

import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import app.model.interfaces.CostEstimation.I_CostEstimationEntry;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import app.model.implementation.*;

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

    public Button performCostEstimationButton;

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
                        .get(4)
                        .getWeightProperty());
        this.box4c.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(5)
                        .getWeightProperty());
        this.box4d.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(6)
                        .getWeightProperty());
        this.box5.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(7)
                        .getWeightProperty());
        this.box6.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(8)
                        .getWeightProperty());
        this.box7.valueProperty()
                .bindBidirectional(Project.getInstance()
                        .getCostEstimation()
                        .getCostEstimationEntries()
                        .get(9)
                        .getWeightProperty());

        classifyRequirementsButton.setOnAction(event -> {
            Classification classification = new Classification();
            classification.show();
        });
    }

    private void performCostEstimation()
    {
        I_Classification classification = Project.getInstance().getClassification();

        int functionTypesSum = calculateFunctionTypesSums(classification);
        double impactFactor = calculateImpactFactor();

        calculatedFPLabel.setText(Double.toString(functionTypesSum * impactFactor));        
    }

    private double calculateImpactFactor()
    {
        int sumInfluencingFactors = 0;

        sumInfluencingFactors += Integer.parseInt(box1.toString());
        sumInfluencingFactors += Integer.parseInt(box2.toString());
        sumInfluencingFactors += Integer.parseInt(box3.toString());
        sumInfluencingFactors += Integer.parseInt(box4a.toString());
        sumInfluencingFactors += Integer.parseInt(box4b.toString());
        sumInfluencingFactors += Integer.parseInt(box4c.toString());
        sumInfluencingFactors += Integer.parseInt(box4d.toString());
        sumInfluencingFactors += Integer.parseInt(box5.toString());
        sumInfluencingFactors += Integer.parseInt(box6.toString());
        sumInfluencingFactors += Integer.parseInt(box7.toString());

        return ((double) sumInfluencingFactors / 100) + 0.7;
    }

    private int calculateFunctionTypesSums(I_Classification classification)
    {
        int sumEi = 0;
        int sumEo = 0;
        int sumEq = 0;
        int sumIlf = 0;
        int sumElf = 0;

        for (int indexClassificationEntries = 0; indexClassificationEntries < classification.getEntries().size(); indexClassificationEntries++)
        {
            I_ClassificationEntry currentClassificationEntry = classification.getEntries().get(indexClassificationEntries);

            if (currentClassificationEntry.getCategory().equals("Eingabedaten (EI)"))
            {
                if (currentClassificationEntry.getClassification().equals("einfach"))
                {
                    sumEi += 3;
                }
                else if (currentClassificationEntry.getClassification().equals("mittel"))
                {
                    sumEi += 4;
                }
                else if (currentClassificationEntry.getClassification().equals("komplex"))
                {
                    sumEi += 6;
                }
            }
            else if (currentClassificationEntry.getCategory().equals("Ausgabedaten (EO)"))
            {
                if (currentClassificationEntry.getClassification().equals("einfach"))
                {
                    sumEo += 4;
                }
                else if (currentClassificationEntry.getClassification().equals("mittel"))
                {
                    sumEo += 5;
                }
                else if (currentClassificationEntry.getClassification().equals("komplex"))
                {
                    sumEo += 7;
                }
            }
            else if (currentClassificationEntry.getCategory().equals("Abfragen (EQ)"))
            {
                if (currentClassificationEntry.getClassification().equals("einfach"))
                {
                    sumEq += 3;
                }
                else if (currentClassificationEntry.getClassification().equals("mittel"))
                {
                    sumEq += 4;
                }
                else if (currentClassificationEntry.getClassification().equals("komplex"))
                {
                    sumEq += 6;
                }
            }
            else if (currentClassificationEntry.getCategory().equals("Datenbestände (ILF)"))
            {
                if (currentClassificationEntry.getClassification().equals("einfach"))
                {
                    sumIlf += 7;
                }
                else if (currentClassificationEntry.getClassification().equals("mittel"))
                {
                    sumIlf += 10;
                }
                else if (currentClassificationEntry.getClassification().equals("komplex"))
                {
                    sumIlf += 15;
                }
            }
            else if (currentClassificationEntry.getCategory().equals("Referenzdaten (ELF)"))
            {
                if (currentClassificationEntry.getClassification().equals("einfach"))
                {
                    sumElf += 5;
                }
                else if (currentClassificationEntry.getClassification().equals("mittel"))
                {
                    sumElf += 7;
                }
                else if (currentClassificationEntry.getClassification().equals("komplex"))
                {
                    sumElf += 10;
                }
            }



        }

        return sumEi + sumEo + sumEq + sumIlf + sumElf;
    }
}
