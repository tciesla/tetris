package models.tetrimino;

import models.point.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tetrimino2DFactoryTest {

    private Tetrimino2DFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new Tetrimino2DFactory();
    }

    @Test
    public void shouldCreateAllTypesOfTetrimino() {
        // when
        Tetrimino2DFactory factory = new Tetrimino2DFactory();
        // then
        assertEquals(TetriminoType.values().length, factory.tetriminoesCache.size());
    }

    @Test
    public void shouldTetriminoesNotBeThisSame() {
        // when
        ITetrimino firstTetriminoI = factory.createSingleTetrimino("Tetrimino2DI");
        ITetrimino secondTetriminoI = factory.createSingleTetrimino("Tetrimino2DI");
        // then
        assertNotSame(firstTetriminoI, secondTetriminoI);
    }

    @Test
    public void shouldCreateRandomTetrimino() {
        // when
        ITetrimino tetrimino = factory.createRandomTetrimino();
        //then
        assertNotNull(tetrimino);
    }

    @Test
    public void shouldCreateTetrimino2DI() {
        // when
        ITetrimino tetrimino = factory.createTetrimino(TetriminoType.I_2D);
        // then
        assertEquals(4, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(0, 0)));
        assertTrue(tetrimino.getPoints().contains(new Point(0, 1)));
        assertTrue(tetrimino.getPoints().contains(new Point(0, 2)));
        assertTrue(tetrimino.getPoints().contains(new Point(0, 3)));
    }

    @Test
    public void shouldCreateTetrimino2DO() {
        // when
        ITetrimino tetrimino = factory.createTetrimino(TetriminoType.O_2D);
        // then
        assertEquals(4, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(0, 0)));
        assertTrue(tetrimino.getPoints().contains(new Point(0, 1)));
        assertTrue(tetrimino.getPoints().contains(new Point(1, 0)));
        assertTrue(tetrimino.getPoints().contains(new Point(1, 1)));
    }
}