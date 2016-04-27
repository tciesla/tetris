package controller.movementcommands;

import models.point.Dimensions;
import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MoveToTheRightCommandTest {

    private ITetrimino tetrimino;
    private MovementCommand command;

    @Before
    public void setUp() throws Exception {
        tetrimino = spy(new Tetrimino());
        command = new MoveToTheRightCommand();
    }

    @Test
    public void shouldCallMoveForward() {
        // when
        command.execute(tetrimino);
        // then
        verify(tetrimino).moveForward(Dimensions.AXIS_Y.getValue());
    }

    @Test
    public void shouldCallMoveBackward() {
        // when
        command.restore(tetrimino);
        // then
        verify(tetrimino).moveBackward(Dimensions.AXIS_Y.getValue());
    }
}