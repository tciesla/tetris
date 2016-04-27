package models.point;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;

@ToString
@EqualsAndHashCode
public class Point implements IPoint {

    private Map<Integer, Integer> coordinates = new HashMap<Integer, Integer>();

    public Point(int... coordinates) {
        for (int dimension = 1; dimension <= coordinates.length; dimension++) {
            int indexOfCoordinate = dimension - 1;
            this.coordinates.put(dimension, coordinates[indexOfCoordinate]);
        }
    }

    @Override
    public int getCoordinate(int dimension) {
        if (dimension > 0 && dimension <= getMaximumDimension()) {
            return coordinates.get(dimension);
        }
        return 0;
    }

    @Override
    public int getX() {
        return getCoordinate(Dimensions.AXIS_X.getValue());
    }

    @Override
    public int getY() {
        return getCoordinate(Dimensions.AXIS_Y.getValue());
    }

    @Override
    public int getZ() {
        return getCoordinate(Dimensions.AXIS_Z.getValue());
    }

    @Override
    public void setCoordinate(int dimension, int value) {
        coordinates.put(dimension, value);
    }

    @Override
    public int getMaximumDimension() {
        return coordinates.size();
    }

    @Override
    public IPoint clone() {
        IPoint point = new Point();
        int maximumDimensionOfCoordinates = getMaximumDimension();
        for (int dimension = 1; dimension <= maximumDimensionOfCoordinates; dimension++) {
            point.setCoordinate(dimension, getCoordinate(dimension));
        }
        return point;
    }

    @Override
    public void rotation(double angle, IPoint rotationPoint) {
        int x = getXCoordinateAfterRotation(angle, rotationPoint);
        int y = getYCoordinateAfterRotation(angle, rotationPoint);
        setCoordinate(Dimensions.AXIS_X.getValue(), x);
        setCoordinate(Dimensions.AXIS_Y.getValue(), y);
    }

    @Override
    public boolean isOutsideMinimalLimit(int dimension, int limit) {
        return coordinates.get(dimension) < limit;
    }

    @Override
    public boolean isOutsideMaximalLimit(int dimension, int limit) {
        return coordinates.get(dimension) >= limit;
    }

    private int getXCoordinateAfterRotation(double angle, IPoint center) {
        double result = 0.0;
        result += (getX() - center.getX()) * cos(angle);
        result -= (getY() - center.getY()) * sin(angle);
        result += center.getX();
        return (int) round(result);
    }

    private int getYCoordinateAfterRotation(double angle, IPoint center) {
        double result = 0.0;
        result += (getX() - center.getX()) * sin(angle);
        result += (getY() - center.getY()) * cos(angle);
        result += center.getY();
        return (int) round(result);
    }
}
