package models.tetrimino;

import models.point.Dimensions;
import models.point.IPoint;
import models.point.Point;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TetriminoTest {

    private Tetrimino tetrimino;

    @Before
    public void setUp() throws Exception {
        tetrimino = spy(new Tetrimino());
    }

    @Test
    public void shouldPointsArrayNotBeNull() {
        // when
        List<IPoint> points = tetrimino.getPoints();
        // then
        assertNotNull(points);
        assertTrue(points.isEmpty());
    }

    @Test
    public void shouldMoveForwardInFirstDimension() {
        // when
        tetrimino.moveForward(Dimensions.AXIS_X.getValue());
        // then
        verify(tetrimino).move(Dimensions.AXIS_X.getValue(), 1);
    }

    @Test
    public void shouldMoveBackwardsInFirstDimension() {
        // when
        tetrimino.moveBackward(Dimensions.AXIS_X.getValue());
        // then
        verify(tetrimino).move(Dimensions.AXIS_X.getValue(), -1);
    }

    @Test
    public void shouldMoveInFirstDimension1UnitForward() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        tetrimino.setPoints(points);
        // when
        tetrimino.move(Dimensions.AXIS_X.getValue(), 1);
        // then
        assertTrue(points.contains(new Point(1, 0)));
        assertTrue(points.contains(new Point(4, 4)));
    }

    @Test
    public void shouldMoveInFirstDimension3UnitsForward() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        tetrimino.setPoints(points);
        // when
        tetrimino.move(Dimensions.AXIS_X.getValue(), 3);
        // then
        assertTrue(points.contains(new Point(3, 0)));
        assertTrue(points.contains(new Point(6, 4)));
    }

    @Test
    public void shouldMoveInSecondDimension1UnitsForward() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        tetrimino.setPoints(points);
        // when
        tetrimino.move(Dimensions.AXIS_Y.getValue(), 1);
        // then
        assertTrue(points.contains(new Point(0, 1)));
        assertTrue(points.contains(new Point(3, 5)));
    }

    @Test
    public void shouldMoveInFirstDimension1UnitsBackward() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        tetrimino.setPoints(points);
        // when
        tetrimino.move(Dimensions.AXIS_X.getValue(), -1);
        // then
        assertTrue(points.contains(new Point(-1, 0)));
        assertTrue(points.contains(new Point(2, 4)));
    }

    @Test
    public void shouldMoveInThirdDimension3UnitsBackward() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0, 0));
        points.add(new Point(3, 4, 5));
        tetrimino.setPoints(points);
        // when
        tetrimino.move(Dimensions.AXIS_Z.getValue(), -3);
        // then
        assertTrue(points.contains(new Point(0, 0, -3)));
        assertTrue(points.contains(new Point(3, 4, 2)));
    }

    @Test
    public void shouldClonedTetriminoNotBeThisSame() {
        // when
        Tetrimino clonedTetrimino = tetrimino.clone();
        // then
        assertNotSame(tetrimino, clonedTetrimino);
    }

    @Test
    public void shouldClonedTetriminoBeEqualsOrigin() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(3, 4));
        tetrimino.setColor(Color.BLUE);
        tetrimino.setPoints(points);
        // when
        Tetrimino clonedTetrimino = tetrimino.clone();
        // then
        assertEquals(tetrimino.getColor(), clonedTetrimino.getColor());
        assertEquals(tetrimino.getPoints(), clonedTetrimino.getPoints());
    }

    @Test
    public void isCollisionWithTetrimino() {
        // given
        tetrimino.getPoints().add(new Point(0, 0));
        ITetrimino otherTetrimino = new Tetrimino();
        otherTetrimino.getPoints().add(new Point(0, 0));
        // when
        boolean isCollision = tetrimino.isCollisionWith(otherTetrimino);
        // then
        assertTrue(isCollision);
    }

    @Test
    public void isNotCollisionWithTetrimino() {
        // given
        tetrimino.getPoints().add(new Point(0, 0));
        ITetrimino otherTetrimino = new Tetrimino();
        otherTetrimino.getPoints().add(new Point(0, 1));
        otherTetrimino.getPoints().add(new Point(1, 0));
        // when
        boolean isCollision = tetrimino.isCollisionWith(otherTetrimino);
        // then
        assertFalse(isCollision);
    }

    @Test
    public void shouldRemove1PointFromTetrimino() {
        // given
        tetrimino.getPoints().add(new Point(1, 2));
        tetrimino.getPoints().add(new Point(3, 4));
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(3, 4));
        // when
        tetrimino.removePoints(points);
        // then
        assertEquals(1, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(1, 2)));
    }

    @Test
    public void shouldRemove2PointsFromTetrimino() {
        // given
        tetrimino.getPoints().add(new Point(0, 0));
        tetrimino.getPoints().add(new Point(0, 1));
        tetrimino.getPoints().add(new Point(1, 1));
        tetrimino.getPoints().add(new Point(1, 2));
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        // when
        tetrimino.removePoints(points);
        // then
        assertEquals(2, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(1, 1)));
        assertTrue(tetrimino.getPoints().contains(new Point(1, 2)));
    }

    @Test
    public void shouldNotRemoveAnyPointFromTetrimino() {
        // given
        tetrimino.getPoints().add(new Point(1, 2));
        tetrimino.getPoints().add(new Point(3, 4));
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(3, 3));
        // when
        tetrimino.removePoints(points);
        // then
        assertEquals(2, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(1, 2)));
        assertTrue(tetrimino.getPoints().contains(new Point(3, 4)));
    }

    @Test
    public void shouldNotRemoveAnyPointFromEmptyTetrimino() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));
        // when
        tetrimino.removePoints(points);
        // then
        assertEquals(0, tetrimino.getPoints().size());
    }
}