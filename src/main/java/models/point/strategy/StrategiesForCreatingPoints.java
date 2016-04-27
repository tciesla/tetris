package models.point.strategy;

import models.point.Dimensions;

import java.util.HashMap;
import java.util.Map;

public class StrategiesForCreatingPoints {

    private static Map<Integer, ICreatePointStrategy> strategies;

    static {
        strategies = new HashMap<Integer, ICreatePointStrategy>();
        strategies.put(Dimensions.SECOND_DIMENSION.getValue(), new CreatePoint2DStrategy());
    }

    public static ICreatePointStrategy getStrategy(int dimensionOfPoint) {
        return strategies.get(dimensionOfPoint);
    }
}
