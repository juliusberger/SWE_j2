package app.controller;

import java.util.HashMap;

/**
 * Created by eju8fe on 6/30/2017.
 */
public interface I_CostEstimationCalculation {
    double getCalculatedFunctionPoints();

    double getCalculatedMenMonths();

    HashMap<String, String> getInfluenceFactors();

    void performCostEstimation();

    void performAutomaticOptimization();
}
