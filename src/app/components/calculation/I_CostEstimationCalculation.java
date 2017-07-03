package app.components.calculation;

import java.util.List;

/**
 * Führt die Aufwandsschätzung sowie deren Optimierung durch. Benutzt wird die Function-Point-Methode.
 */
public interface I_CostEstimationCalculation {
    double getCalculatedFunctionPoints();

    double getCalculatedMenMonths();

    List<Integer> getInfluenceFactors();

    void setInfluenceFactors(Integer... influenceFactors) throws IllegalArgumentException;

    void performCostEstimation();

    void performAutomaticOptimization();
}
