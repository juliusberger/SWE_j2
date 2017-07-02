package app.components;

import java.util.Map;

/**
 * Created by eju8fe on 6/30/2017.
 */
public interface I_CostEstimationCalculation {
    double getCalculatedFunctionPoints();

    double getCalculatedMenMonths();

    Map<String, String> getInfluenceFactors();

    void performCostEstimation();

    void performAutomaticOptimization();
}
