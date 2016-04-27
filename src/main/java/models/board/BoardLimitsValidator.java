package models.board;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import models.point.Dimensions;
import models.point.IPoint;
import models.tetrimino.ITetrimino;

import java.util.HashMap;
import java.util.Map;

public class BoardLimitsValidator {

    Map<Integer, Integer> minimalLimits = new HashMap<Integer, Integer>();
    Map<Integer, Integer> maximalLimits = new HashMap<Integer, Integer>();

    public BoardLimitsValidator(int xMinLimit, int xMaxLimit, int yMinLimit, int yMaxLimit, int zMinLimit, int zMaxLimit) {
        this(xMinLimit, xMaxLimit, yMinLimit, yMaxLimit);
        minimalLimits.put(Dimensions.AXIS_Z.getValue(), zMinLimit);
        maximalLimits.put(Dimensions.AXIS_Z.getValue(), zMaxLimit);
    }

    public BoardLimitsValidator(int xMinLimit, int xMaxLimit, int yMinLimit, int yMaxLimit) {
        minimalLimits.put(Dimensions.AXIS_X.getValue(), xMinLimit);
        maximalLimits.put(Dimensions.AXIS_X.getValue(), xMaxLimit);
        minimalLimits.put(Dimensions.AXIS_Y.getValue(), yMinLimit);
        maximalLimits.put(Dimensions.AXIS_Y.getValue(), yMaxLimit);
    }

    public int getMinimalLimit(int dimension) {
        return minimalLimits.get(dimension);
    }

    public int getMaximalLimit(int dimension) {
        return maximalLimits.get(dimension);
    }

    public boolean isOutsideTheLimits(ITetrimino tetriminoToAdd) {
        return Lists.newArrayList(Collections2.filter(tetriminoToAdd.getPoints(), new Predicate<IPoint>() {
            @Override
            public boolean apply(IPoint point) {
                return isOutsideMinimalLimits(point) || isOutsideMaximalLimits(point);
            }
        })).size() > 0;
    }

    private boolean isOutsideMinimalLimits(IPoint point) {
        for (Map.Entry<Integer, Integer> entry : minimalLimits.entrySet()) {
            if (point.isOutsideMinimalLimit(entry.getKey(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOutsideMaximalLimits(IPoint point) {
        for (Map.Entry<Integer, Integer> entry : maximalLimits.entrySet()) {
            if (point.isOutsideMaximalLimit(entry.getKey(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
