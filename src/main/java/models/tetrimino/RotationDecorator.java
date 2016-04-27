package models.tetrimino;

import models.point.IPoint;

import java.awt.*;
import java.util.List;

public abstract class RotationDecorator implements ITetrimino {

    protected ITetrimino decoratedTetrimino;

    public RotationDecorator(ITetrimino decoratedTetrimino) {
        this.decoratedTetrimino = decoratedTetrimino;
    }

    @Override
    public void moveForward(int dimension) {
        decoratedTetrimino.moveForward(dimension);
    }

    @Override
    public void moveBackward(int dimension) {
        decoratedTetrimino.moveBackward(dimension);
    }

    @Override
    public void move(int dimension, int offset) {
        decoratedTetrimino.move(dimension, offset);
    }

    @Override
    public void removePoints(List<IPoint> pointsToRemove) {
        decoratedTetrimino.removePoints(pointsToRemove);
    }

    @Override
    public abstract ITetrimino clone();

    @Override
    public List<IPoint> getPoints() {
        return decoratedTetrimino.getPoints();
    }

    @Override
    public Color getColor() {
        return decoratedTetrimino.getColor();
    }

    @Override
    public boolean isCollisionWith(ITetrimino otherTetrimino) {
        return decoratedTetrimino.isCollisionWith(otherTetrimino);
    }
}
