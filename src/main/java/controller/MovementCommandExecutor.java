package controller;

import controller.movementcommands.MovementCommand;

public class MovementCommandExecutor {

    TetrisGameController controller;

    public MovementCommandExecutor(TetrisGameController controller) {
        this.controller = controller;
    }

    public void executeMovementCommand(MovementCommand command) throws MovementNotPossibleException {
        try {
            tryToExecuteMovementCommand(command);
            EventDispatcher.getInstance().sendEvent(controller, "updateView");
        } catch (MovementNotPossibleException exception) {
            restorePreviousGameState(command);
            throw exception;
        }
    }

    private void tryToExecuteMovementCommand(MovementCommand command) throws MovementNotPossibleException {
        controller.getGameBoardModel().remove(controller.getActualTetrimino());
        command.execute(controller.getActualTetrimino());
        if (!controller.getGameBoardModel().add(controller.getActualTetrimino())) {
            throw new MovementNotPossibleException();
        }
    }

    private void restorePreviousGameState(MovementCommand command) {
        command.restore(controller.getActualTetrimino());
        controller.getGameBoardModel().add(controller.getActualTetrimino());
    }
}
