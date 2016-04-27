package models.tetrimino;

import models.point.Dimensions;
import models.point.IPoint;
import models.point.Point;
import org.junit.Before;
import org.junit.Test;
import views.row.GameRowView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Rotation2DDecoratorTest {

    private Tetrimino2DFactory tetriminoFactory;

    @Before
    public void setUp() throws Exception {
        tetriminoFactory = new Tetrimino2DFactory();
    }

    @Test
    public void shouldCreateRotationPointOfTetriminoS() {
        // given
        ITetrimino tetriminoZ = tetriminoFactory.createTetrimino(TetriminoType.Z_2D);
        Rotation2DDecorator rotation2DDecorator = new Rotation2DDecorator(tetriminoZ);
        // when
        IPoint rotationPoint = rotation2DDecorator.createRotationPoint();
        // then
        assertEquals(new Point(0, 1), rotationPoint);
    }

    @Test
    public void shouldRotateTetriminoI() {
        // given
        ITetrimino tetriminoI = tetriminoFactory.createTetrimino(TetriminoType.I_2D);
        tetriminoI = new Rotation2DDecorator(tetriminoI);
        tetriminoI.move(Dimensions.AXIS_X.getValue(), 1);
        // when
        tetriminoI.rotation();
        // then
        List<IPoint> points = tetriminoI.getPoints();
        assertTrue(points.contains(new Point(0, 1)));
        assertTrue(points.contains(new Point(1, 1)));
        assertTrue(points.contains(new Point(2, 1)));
        assertTrue(points.contains(new Point(3, 1)));
    }

    @Test
    public void shouldRotateTetriminoT() {
        // given
        ITetrimino tetriminoT = tetriminoFactory.createTetrimino(TetriminoType.T_2D);
        tetriminoT = new Rotation2DDecorator(tetriminoT);
        // when
        tetriminoT.rotation();
        // then
        List<IPoint> points = tetriminoT.getPoints();
        assertTrue(points.contains(new Point(0, 2)));
        assertTrue(points.contains(new Point(1, 2)));
        assertTrue(points.contains(new Point(2, 2)));
        assertTrue(points.contains(new Point(1, 1)));
    }

    @Test
    public void shouldRotateTetriminoOHaveNoEffect() {
        // given
        ITetrimino tetriminoO = tetriminoFactory.createTetrimino(TetriminoType.O_2D);
        tetriminoO = new Rotation2DDecorator(tetriminoO);
        // when
        tetriminoO.rotation();
        // then
        List<IPoint> points = tetriminoO.getPoints();
        assertTrue(points.contains(new Point(0, 0)));
        assertTrue(points.contains(new Point(0, 1)));
        assertTrue(points.contains(new Point(1, 0)));
        assertTrue(points.contains(new Point(1, 1)));
    }

    @Test
    public void shouldCallMoveForwardFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        // when
        decoratedTetrimino.moveForward(Dimensions.AXIS_X.getValue());
        // then
        verify(tetrimino).moveForward(Dimensions.AXIS_X.getValue());
    }

    @Test
    public void shouldCallMoveBackwardFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        // when
        decoratedTetrimino.moveBackward(Dimensions.AXIS_X.getValue());
        // then
        verify(tetrimino).moveBackward(Dimensions.AXIS_X.getValue());
    }

    @Test
    public void shouldCallMoveFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        // when
        decoratedTetrimino.move(Dimensions.AXIS_X.getValue(), 1);
        // then
        verify(tetrimino).move(Dimensions.AXIS_X.getValue(), 1);
    }

    @Test
    public void shouldCallRemovePointsFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        // when
        decoratedTetrimino.removePoints(points);
        // then
        verify(tetrimino).removePoints(points);
    }

    @Test
    public void shouldCallGetPointsFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        // when
        decoratedTetrimino.getPoints();
        // then
        verify(tetrimino).getPoints();
    }

    @Test
    public void shouldCallGetColorFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        // when
        decoratedTetrimino.getColor();
        // then
        verify(tetrimino).getColor();
    }

    @Test
    public void shouldCallFillRowFromTetrimino() {
        // given
        ITetrimino tetrimino = mock(Tetrimino.class);
        ITetrimino decoratedTetrimino = new Rotation2DDecorator(tetrimino);
        GameRowView row = mock(GameRowView.class);
        // when
        decoratedTetrimino.fillRow(0, row);
        // then
        verify(tetrimino).fillRow(0, row);
    }
}
