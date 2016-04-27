package models.tetrimino;

import models.point.Point;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TetriminoLoaderTest {

    private TetriminoLoader loader;

    @Before
    public void setUp() throws Exception {
        loader = new TetriminoLoader();
    }

    @Test
    public void shouldReturnCyanColor() {
        // when
        loader.loadTetrimino("Tetrimino2DI");
        // then
        assertEquals(Color.CYAN, loader.getColor());
    }

    @Test
    public void shouldReturnRedColor() {
        // when
        loader.loadTetrimino("Tetrimino2DZ");
        // then
        assertEquals(Color.RED, loader.getColor());
    }

    @Test
    public void shouldReturnTetrimino2DIPoints() {
        // when
        loader.loadTetrimino("Tetrimino2DI");
        // then
        assertTrue(loader.getPoints().contains(new Point(0, 0)));
        assertTrue(loader.getPoints().contains(new Point(0, 1)));
        assertTrue(loader.getPoints().contains(new Point(0, 2)));
        assertTrue(loader.getPoints().contains(new Point(0, 3)));
    }

    @Test
    public void shouldReturnTetrimino2DTPoints() {
        // when
        loader.loadTetrimino("Tetrimino2DT");
        // then
        assertTrue(loader.getPoints().contains(new Point(0, 1)));
        assertTrue(loader.getPoints().contains(new Point(1, 0)));
        assertTrue(loader.getPoints().contains(new Point(1, 1)));
        assertTrue(loader.getPoints().contains(new Point(1, 2)));
    }

    @Test(expected = NullPointerException.class)
    public void shouldBeNullPointerExceptionIfTetriminoNotExistsInJsonFile() {
        // when
        loader.loadTetrimino("TetriminoNotAvailable");
    }
}
