package controller.eventstrategies;

import controller.MovementNotPossibleException;
import controller.TetrisGameController;
import controller.movementcommands.MoveToNextRowCommand;
import models.point.Dimensions;
import models.tetrimino.Tetrimino2DFactory;

public class MoveToNextRowEventStrategy implements EventStrategy {

    private final static int OFFSET_TO_MIDDLE_COLUMN = 3;
    private static final Tetrimino2DFactory tetriminoFactory = new Tetrimino2DFactory();

    private TetrisGameController controller;

    @Override
    public void execute(TetrisGameController controller) {
        this.controller = controller;
        moveActualTetriminoToNextRow();
    }

    private void moveActualTetriminoToNextRow() {
        try {
            controller.getExecutor().executeMovementCommand(new MoveToNextRowCommand());
        } catch (MovementNotPossibleException exception) {
            int removedRows = controller.getGameBoardModel().removeFullRows();
            controller.setPointsAmount(controller.getPointsAmount() + removedRows);
            controller.getGameTimer().updateDelay(controller.getPointsAmount());
            tryToAddNextTetrimino();
        }
    }

    private void tryToAddNextTetrimino() {
        try {
            controller.setActualTetrimino(controller.getNextTetrimino());
            controller.getActualTetrimino().move(Dimensions.AXIS_Y.getValue(), OFFSET_TO_MIDDLE_COLUMN);
            controller.setNextTetrimino(tetriminoFactory.createRandomTetrimino());
            controller.getExecutor().executeMovementCommand(new MoveToNextRowCommand());
        } catch (MovementNotPossibleException exception) {
            controller.getGameTimer().stop();
        }
    }
}
