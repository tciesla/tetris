package models.tetrimino;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import models.point.IPoint;
import views.row.GameRowView;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Tetrimino implements ITetrimino, Cloneable {

    private static final int OFFSET_ONE_UNIT_FORWARD = 1;
    private static final int OFFSET_ONE_UNIT_BACKWARD = -1;

    @Getter @Setter private Color color;
    @Getter @Setter private List<IPoint> points = new ArrayList<IPoint>();

    @Override
    public void moveForward(int dimension) {
        move(dimension, OFFSET_ONE_UNIT_FORWARD);
    }

    @Override
    public void moveBackward(int dimension) {
        move(dimension, OFFSET_ONE_UNIT_BACKWARD);
    }

    @Override
    public void move(int dimension, int offset) {
        for (IPoint point : points) {
            int coordinate = point.getCoordinate(dimension);
            coordinate += offset;
            point.setCoordinate(dimension, coordinate);
        }
    }

    @Override
    public void removePoints(List<IPoint> pointsToRemove) {
        for (IPoint point : pointsToRemove) {
            points.remove(point);
        }
    }

    @Override
    public void rotation() {}

    @Override
    public Tetrimino clone() {
        return TetriminoBuilder.aTetrimino()
                .color(color)
                .points(points)
                .build();
    }

    @Override
    public boolean isCollisionWith(ITetrimino otherTetrimino) {
        Set<IPoint> intersectedPoints = new HashSet<IPoint>();
        intersectedPoints.addAll(points);
        intersectedPoints.addAll(otherTetrimino.getPoints());
        return intersectedPoints.size() < points.size() + otherTetrimino.getPoints().size();
    }

    @Override
    public void fillRow(final int rowNumber, GameRowView row) {
        List<IPoint> pointsInRow = Lists.newArrayList(Collections2.filter(points, new Predicate<IPoint>() {
            @Override
            public boolean apply(IPoint point) {
                return point.getX() == rowNumber;
            }
        }));
        for (IPoint point : pointsInRow) {
            row.getField(point.getY()).setBackground(getColor());
        }
    }
}
