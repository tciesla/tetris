package controller;

import controller.movementcommands.MoveToNextRowCommand;
import models.board.BoardLimitsValidator;
import models.board.TetrisGameBoardModel;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

public class MovementCommandExecutorTest {

    @Test
    public void shouldInitializeController() {
        // given
        TetrisGameController controller = mock(TetrisGameController.class);
        // when
        MovementCommandExecutor executor = new MovementCommandExecutor(controller);
        // then
        assertNotNull(executor.controller);
        assertSame(controller, executor. controller);
    }

    @Test
    public void shouldExecuteMovementCommand() throws MovementNotPossibleException {
        // given
        TetrisGameController controller = new TetrisGameController();
        MovementCommandExecutor executor = new MovementCommandExecutor(controller);
        // when
        executor.executeMovementCommand(new MoveToNextRowCommand());
    }

    @Test(expected = MovementNotPossibleException.class)
    public void shouldNotExecuteMovementCommand() throws MovementNotPossibleException {
        // given
        TetrisGameBoardModel board = new TetrisGameBoardModel(new BoardLimitsValidator(0, 1, 0, 20));
        TetrisGameController controller = new TetrisGameController();
        controller.gameBoardModel = board;
        MovementCommandExecutor executor = new MovementCommandExecutor(controller);
        // when
        executor.executeMovementCommand(new MoveToNextRowCommand());
    }
}