package models.tetrimino;

import models.point.*;
import models.point.Point;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TetriminoBuilderTest {

    @Test
    public void shouldDefaultBuildTetriminoWithNoPoints() {
        // when
        ITetrimino tetrimino = TetriminoBuilder.aTetrimino().build();
        // then
        assertEquals(0, tetrimino.getPoints().size());
    }

    @Test
    public void shouldDefaultBuildTetriminoWithRedColor() {
        // when
        ITetrimino tetrimino = TetriminoBuilder.aTetrimino().build();
        // then
        assertEquals(Color.RED, tetrimino.getColor());
    }

    @Test
    public void shouldBuildTetriminoWithGreenColor() {
        // when
        ITetrimino tetrimino = TetriminoBuilder.aTetrimino()
                .color(Color.GREEN).build();
        // then
        assertEquals(Color.GREEN, tetrimino.getColor());
    }

    @Test
    public void shouldBuildTetriminoWith2Points() {
        // given
        List<IPoint> points = new ArrayList<IPoint>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 4));
        // when
        ITetrimino tetrimino = TetriminoBuilder.aTetrimino()
                .points(points).build();
        // then
        assertEquals(2, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(1, 1)));
        assertTrue(tetrimino.getPoints().contains(new Point(2, 4)));
    }
}