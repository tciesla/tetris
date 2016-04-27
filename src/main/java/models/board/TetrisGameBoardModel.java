package models.board;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import models.point.Dimensions;
import models.point.IPoint;
import models.tetrimino.ITetrimino;

import java.util.List;
import java.util.Set;

public class TetrisGameBoardModel extends GameBoardModel {

    public TetrisGameBoardModel() {
        super();
    }

    public TetrisGameBoardModel(BoardLimitsValidator validator) {
        super(validator);
    }

    public int removeFullRows() {
        int removedRowsCounter = 0;
        int rowsAmount = limitsValidator.getMaximalLimit(Dimensions.AXIS_X.getValue());
        for (int rowPosition = 0; rowPosition < rowsAmount; rowPosition++) {
            if (isRowFull(rowPosition)) {
                removeRow(rowPosition--);
                removedRowsCounter++;
            }
        }
        return removedRowsCounter;
    }

    private boolean isRowFull(final int rowNumber) {
        List<IPoint> pointsInRow = findPointsWithRowNumber(rowNumber);
        int columnAmount = limitsValidator.getMaximalLimit(Dimensions.AXIS_Y.getValue());
        return pointsInRow.size() == columnAmount;
    }

    private List<IPoint> findPointsWithRowNumber(final int rowNumber) {
        Set<IPoint> gameBoardPoints = getAllGameBoardPoints();
        return Lists.newArrayList(Collections2.filter(gameBoardPoints, new Predicate<IPoint>() {
            @Override
            public boolean apply(IPoint point) {
                return point.getX() == rowNumber;
            }
        }));
    }

    private Set<IPoint> getAllGameBoardPoints() {
        Set<IPoint> points = Sets.newHashSet();
        for (ITetrimino tetrimino : tetriminoes) {
            points.addAll(tetrimino.getPoints());
        }
        return points;
    }

    private void removeRow(int rowNumber) {
        final List<IPoint> pointsToRemove = findPointsWithRowNumber(rowNumber);
        for (ITetrimino tetrimino : tetriminoes) {
            tetrimino.removePoints(pointsToRemove);
        }
        removeTetriminoesWithNoPoints();
        moveHigherRowsOneLevelDown(rowNumber);
    }

    private void removeTetriminoesWithNoPoints() {
        List<ITetrimino> emptyTetriminoes = Lists.newArrayList(Collections2.filter(tetriminoes, new Predicate<ITetrimino>() {
            @Override
            public boolean apply(ITetrimino tetrimino) {
                return tetrimino.getPoints().size() == 0;
            }
        }));
        tetriminoes.removeAll(emptyTetriminoes);
    }

    private void moveHigherRowsOneLevelDown(final int rowNumber) {
        Set<IPoint> points = getAllGameBoardPoints();
        points = Sets.newHashSet(Collections2.filter(points, new Predicate<IPoint>() {
            @Override
            public boolean apply(IPoint point) {
                return point.getX() < rowNumber;
            }
        }));
        for (IPoint point : points) {
            point.setCoordinate(Dimensions.AXIS_X.getValue(), point.getX() + 1);
        }
    }
}
