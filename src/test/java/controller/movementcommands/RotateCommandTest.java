package controller.movementcommands;

import models.point.Point;
import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class RotateCommandTest {

    private ITetrimino tetrimino;
    private RotateCommand command;

    @Before
    public void setUp() throws Exception {
        tetrimino = spy(new Tetrimino());
        command = new RotateCommand();
    }

    @Test
    public void shouldCallRotationAndStoreTetrimino() {
        // when
        command.execute(tetrimino);
        // then
        verify(tetrimino).rotation();
        assertNotNull(command.memento);
    }

    @Test
    public void shouldRestoreTetriminoState() {
        // given
        command.memento = new Tetrimino();
        command.memento.getPoints().add(new Point(1, 1));
        command.memento.getPoints().add(new Point(2, 3));
        // when
        command.restore(tetrimino);
        // then
        assertEquals(2, tetrimino.getPoints().size());
        assertTrue(tetrimino.getPoints().contains(new Point(1, 1)));
        assertTrue(tetrimino.getPoints().contains(new Point(2, 3)));
    }
}