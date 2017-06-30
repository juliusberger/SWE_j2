package app.controller;

import app.Constants;
import app.InfoDialog;
import app.model.implementation.Project;
import app.model.interfaces.CostEstimation.I_Classification;
import app.model.interfaces.CostEstimation.I_ClassificationEntry;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Julius on 26.04.17.
 */
public class CostEstimationController implements Initializable {

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

    public Button _performCostEstimationButton;

    public Label _calculatedFPLabel;
    public Label _calculatedMMLabel;

    public Button _manualOptimizationButton;
    public Button _automaticOptimizationButton;

    private boolean _isOptimized = false;


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

        _classifyRequirementsButton.setOnAction(event -> ClassificationController.showClassificationDialog());

        _performCostEstimationButton.setOnAction(event -> {
            performCostEstimation();
            _isOptimized = false;
        });

        _manualOptimizationButton.setOnAction(event -> {
            ClassificationController.showClassificationDialog();
            performCostEstimation();
        });

        _automaticOptimizationButton.setOnAction(event -> {
            performAutomaticOptimization();
            _isOptimized = true;
        });
    }

    private void performCostEstimation() {
        I_Classification classification = Project.getInstance().getClassification();

        int _functionTypesSum = calculateFunctionTypesSums(classification);
        double _impactFactor = calculateImpactFactor();
        double _functionPoints = _functionTypesSum * _impactFactor;
        double _menMonths = calculateMenMonths(_functionPoints);

        _calculatedFPLabel.setText(Double.toString(Math.round(_functionPoints * 100) / 100.0));
        _calculatedMMLabel.setText(Double.toString(Math.round(_menMonths * 100.0) / 100.0));
    }

    private double calculateImpactFactor() {
        int _sumInfluencingFactors = 0;

        _sumInfluencingFactors += _box1.getValue().equals("") ? 0 : Integer.parseInt(_box1.getValue());
        _sumInfluencingFactors += _box2.getValue().equals("") ? 0 : Integer.parseInt(_box2.getValue());
        _sumInfluencingFactors += _box3.getValue().equals("") ? 0 : Integer.parseInt(_box3.getValue());
        _sumInfluencingFactors += _box4a.getValue().equals("") ? 0 : Integer.parseInt(_box4a.getValue());
        _sumInfluencingFactors += _box4b.getValue().equals("") ? 0 : Integer.parseInt(_box4b.getValue());
        _sumInfluencingFactors += _box4c.getValue().equals("") ? 0 : Integer.parseInt(_box4c.getValue());
        _sumInfluencingFactors += _box4d.getValue().equals("") ? 0 : Integer.parseInt(_box4d.getValue());
        _sumInfluencingFactors += _box5.getValue().equals("") ? 0 : Integer.parseInt(_box5.getValue());
        _sumInfluencingFactors += _box6.getValue().equals("") ? 0 : Integer.parseInt(_box6.getValue());
        _sumInfluencingFactors += _box7.getValue().equals("") ? 0 : Integer.parseInt(_box7.getValue());

        return ((double) _sumInfluencingFactors / 100) + 0.7;
    }

    private int calculateFunctionTypesSums(I_Classification classification) {
        int _sumEi = 0;
        int _sumEo = 0;
        int _sumEq = 0;
        int _sumIlf = 0;
        int _sumElf = 0;

        for (int indexClassificationEntries = 0; indexClassificationEntries < classification.getEntries().size(); indexClassificationEntries++) {
            I_ClassificationEntry currentClassificationEntry = classification.getEntries().get(indexClassificationEntries);

            if (currentClassificationEntry.getCategory().equals("Eingabedaten (EI)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEi += 3;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEi += 4;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEi += 6;
                }
            } else if (currentClassificationEntry.getCategory().equals("Ausgabedaten (EO)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEo += 4;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEo += 5;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEo += 7;
                }
            } else if (currentClassificationEntry.getCategory().equals("Abfragen (EQ)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumEq += 3;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumEq += 4;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumEq += 6;
                }
            } else if (currentClassificationEntry.getCategory().equals("Datenbestände (ILF)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumIlf += 7;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumIlf += 10;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumIlf += 15;
                }
            } else if (currentClassificationEntry.getCategory().equals("Referenzdaten (ELF)")) {
                if (currentClassificationEntry.getClassification().equals("einfach")) {
                    _sumElf += 5;
                } else if (currentClassificationEntry.getClassification().equals("mittel")) {
                    _sumElf += 7;
                } else if (currentClassificationEntry.getClassification().equals("komplex")) {
                    _sumElf += 10;
                }
            }
        }

        return _sumEi + _sumEo + _sumEq + _sumIlf + _sumElf;
    }

    private double calculateMenMonths(double _functionPoints) {
        double _menMonths = 0.0;

        // falls FunctionPoints nicht zwischen 50 und 2900 liegen, wird Schätzfunktion von Jones genutzt,
        // andernfalls die IBM-Korrespondeztabelle von 1984

        if (_functionPoints < 50 || _functionPoints > 2900) {
            _menMonths = Math.pow(_functionPoints, 0.4);
        } else {
            for (Map.Entry<Integer, Integer> currentCorrelationEntry : Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.entrySet()) {
                // falls Bedingung wahr ist, ist untere Grenze des Intervalls gefunden
                if (currentCorrelationEntry.getKey() < _functionPoints) {
                    double _lowerBoundFunctionPoints = currentCorrelationEntry.getKey();
                    double _upperBoundFunctionPoints = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.higherKey(currentCorrelationEntry.getKey());
                    double _lowerBoundMenMonths = currentCorrelationEntry.getValue();
                    double _upperBoundMenMonths = Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.get(Constants.FUNCTION_POINTS_MEN_MONTHS_CORRELATION.higherKey(currentCorrelationEntry.getKey()));

                    // lineare Interpolation zwischen den Intervallgrenzen
                    _menMonths = ((_upperBoundMenMonths - _lowerBoundMenMonths) / (_upperBoundFunctionPoints - _lowerBoundFunctionPoints)) * (_functionPoints - _lowerBoundFunctionPoints) + _lowerBoundMenMonths;
                }
            }
        }

        return _menMonths;
    }

    private void performAutomaticOptimization() {
        if (!areInfluenceFieldsValid()) {
            InfoDialog.show("Automatische Optimierung", "Fehler bei der Optimierung", "Für die automatische Optimierung müssen alle Einflussfaktoren gesetzt sein!", Alert.AlertType.ERROR);
        } else {
            if (_isOptimized) {
                InfoDialog.show("Automatische Optimierung", "Optimierung bereits durchgeführt", "Automatische Optimierung der Einflussfaktoren wurde bereits einmal durchgeführt!", Alert.AlertType.ERROR);
            } else {
                if (Integer.parseInt(_box1.getValue()) > 0 && Integer.parseInt(_box1.getValue()) < 4)
                    _box1.setValue(Integer.toString(Integer.parseInt(_box1.getValue()) - 1));
                else if (Integer.parseInt(_box1.getValue()) > 3 && Integer.parseInt(_box1.getValue()) < 6)
                    _box1.setValue(Integer.toString(Integer.parseInt(_box1.getValue()) - 2));

                if (Integer.parseInt(_box2.getValue()) > 0 && Integer.parseInt(_box2.getValue()) < 4)
                    _box2.setValue(Integer.toString(Integer.parseInt(_box2.getValue()) - 1));
                else if (Integer.parseInt(_box2.getValue()) > 3 && Integer.parseInt(_box2.getValue()) < 6)
                    _box2.setValue(Integer.toString(Integer.parseInt(_box2.getValue()) - 2));

                if (Integer.parseInt(_box3.getValue()) > 0 && Integer.parseInt(_box3.getValue()) < 4)
                    _box3.setValue(Integer.toString(Integer.parseInt(_box3.getValue()) - 1));
                else if (Integer.parseInt(_box3.getValue()) > 3 && Integer.parseInt(_box3.getValue()) < 6)
                    _box3.setValue(Integer.toString(Integer.parseInt(_box3.getValue()) - 2));

                if (Integer.parseInt(_box4a.getValue()) > 0 && Integer.parseInt(_box4a.getValue()) < 5)
                    _box4a.setValue(Integer.toString(Integer.parseInt(_box4a.getValue()) - 1));
                else if (Integer.parseInt(_box4a.getValue()) > 4 && Integer.parseInt(_box4a.getValue()) < 8)
                    _box4a.setValue(Integer.toString(Integer.parseInt(_box4a.getValue()) - 2));
                else if (Integer.parseInt(_box4a.getValue()) > 7 && Integer.parseInt(_box4a.getValue()) < 11)
                    _box4a.setValue(Integer.toString(Integer.parseInt(_box4a.getValue()) - 3));

                if (Integer.parseInt(_box4b.getValue()) > 0 && Integer.parseInt(_box4b.getValue()) < 4)
                    _box4b.setValue(Integer.toString(Integer.parseInt(_box4b.getValue()) - 1));
                else if (Integer.parseInt(_box4b.getValue()) > 3 && Integer.parseInt(_box4b.getValue()) < 6)
                    _box4b.setValue(Integer.toString(Integer.parseInt(_box4b.getValue()) - 2));

                if (Integer.parseInt(_box4c.getValue()) > 0 && Integer.parseInt(_box4c.getValue()) < 5)
                    _box4c.setValue(Integer.toString(Integer.parseInt(_box4c.getValue()) - 1));
                else if (Integer.parseInt(_box4c.getValue()) > 4 && Integer.parseInt(_box4c.getValue()) < 8)
                    _box4c.setValue(Integer.toString(Integer.parseInt(_box4c.getValue()) - 2));
                else if (Integer.parseInt(_box4c.getValue()) > 7 && Integer.parseInt(_box4c.getValue()) < 11)
                    _box4c.setValue(Integer.toString(Integer.parseInt(_box4c.getValue()) - 3));

                if (Integer.parseInt(_box4d.getValue()) > 0 && Integer.parseInt(_box4d.getValue()) < 4)
                    _box4d.setValue(Integer.toString(Integer.parseInt(_box4d.getValue()) - 1));
                else if (Integer.parseInt(_box4d.getValue()) > 3 && Integer.parseInt(_box4d.getValue()) < 6)
                    _box4d.setValue(Integer.toString(Integer.parseInt(_box4d.getValue()) - 2));

                if (Integer.parseInt(_box5.getValue()) > 0 && Integer.parseInt(_box5.getValue()) < 4)
                    _box5.setValue(Integer.toString(Integer.parseInt(_box5.getValue()) - 1));
                else if (Integer.parseInt(_box5.getValue()) > 3 && Integer.parseInt(_box5.getValue()) < 6)
                    _box5.setValue(Integer.toString(Integer.parseInt(_box5.getValue()) - 2));

                if (Integer.parseInt(_box6.getValue()) > 0 && Integer.parseInt(_box6.getValue()) < 4)
                    _box6.setValue(Integer.toString(Integer.parseInt(_box6.getValue()) - 1));
                else if (Integer.parseInt(_box6.getValue()) > 3 && Integer.parseInt(_box6.getValue()) < 6)
                    _box6.setValue(Integer.toString(Integer.parseInt(_box6.getValue()) - 2));

                if (Integer.parseInt(_box7.getValue()) > 0 && Integer.parseInt(_box7.getValue()) < 4)
                    _box7.setValue(Integer.toString(Integer.parseInt(_box7.getValue()) - 1));
                else if (Integer.parseInt(_box7.getValue()) > 3 && Integer.parseInt(_box7.getValue()) < 6)
                    _box7.setValue(Integer.toString(Integer.parseInt(_box7.getValue()) - 2));

                performCostEstimation();

                InfoDialog.show("Automatische Optimierung", "Optimierung erfolgreich durchgeführt", "Automatische Optimierung der Einflussfaktoren erfolgreich durchgeführt!");
            }
        }
    }

    private boolean areInfluenceFieldsValid() {
        boolean validFields = false;
        try {
            Integer.parseInt(_box1.getValue());
            Integer.parseInt(_box2.getValue());
            Integer.parseInt(_box3.getValue());
            Integer.parseInt(_box4a.getValue());
            Integer.parseInt(_box4b.getValue());
            Integer.parseInt(_box4c.getValue());
            Integer.parseInt(_box4d.getValue());
            Integer.parseInt(_box5.getValue());
            Integer.parseInt(_box6.getValue());
            Integer.parseInt(_box7.getValue());

            validFields = true;
        } catch (NumberFormatException ignored) {
        }
        return validFields;
    }
}
