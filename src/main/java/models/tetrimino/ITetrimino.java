package models.tetrimino;

import models.point.IPoint;
import views.row.GameRowView;

import java.awt.*;
import java.util.List;

public interface ITetrimino {

    void moveForward(int dimension);

    void moveBackward(int dimension);

    void move(int dimension, int offset);

    void removePoints(List<IPoint> pointsToRemove);

    void rotation();

    ITetrimino clone();

    List<IPoint> getPoints();

    Color getColor();

    boolean isCollisionWith(ITetrimino otherTetrimino);

    void fillRow(int number, GameRowView row);
}
