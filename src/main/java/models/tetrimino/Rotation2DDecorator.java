package models.tetrimino;

import models.point.Dimensions;
import models.point.IPoint;
import models.point.Point;
import views.row.GameRowView;

import static java.lang.Math.*;

public class Rotation2DDecorator extends RotationDecorator {

    private static final int ROTATION_ANGLE_IN_DEGREES = 90;

    public Rotation2DDecorator(ITetrimino decoratedTetrimino) {
        super(decoratedTetrimino);
    }

    @Override
    public ITetrimino clone() {
        return new Rotation2DDecorator(decoratedTetrimino.clone());
    }

    @Override
    public void rotation() {
        double angle = toRadians(ROTATION_ANGLE_IN_DEGREES);
        IPoint rotationPoint = createRotationPoint();
        rotateAllTetriminoPoints(angle, rotationPoint);
        moveAllTetriminoPointsToNextRow();
    }

    IPoint createRotationPoint() {
        int massXCoordinates = createPointsMass(Dimensions.AXIS_X.getValue());
        int massYCoordinates = createPointsMass(Dimensions.AXIS_Y.getValue());
        return new Point(massXCoordinates, massYCoordinates);
    }

    private int createPointsMass(int dimension) {
        int pointsMass = 0;
        for (IPoint point : decoratedTetrimino.getPoints()) {
            pointsMass += point.getCoordinate(dimension);
        }
        return pointsMass / decoratedTetrimino.getPoints().size();
    }

    private void rotateAllTetriminoPoints(double angle, IPoint rotationPoint) {
        for (IPoint point : decoratedTetrimino.getPoints()) {
            point.rotation(angle, rotationPoint);
        }
    }

    private void moveAllTetriminoPointsToNextRow() {
        for (IPoint point : decoratedTetrimino.getPoints()) {
            point.setCoordinate(Dimensions.AXIS_X.getValue(), point.getX() + 1);
        }
    }

    @Override
    public void fillRow(int number, GameRowView row) {
        decoratedTetrimino.fillRow(number, row);
    }
}
