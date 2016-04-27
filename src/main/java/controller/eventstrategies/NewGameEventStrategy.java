package controller.eventstrategies;

import controller.EventDispatcher;
import controller.TetrisGameController;
import models.board.TetrisGameBoardModel;
import models.point.Dimensions;
import models.tetrimino.Tetrimino2DFactory;

public class NewGameEventStrategy implements EventStrategy {

    private final static int OFFSET_TO_MIDDLE_COLUMN = 3;
    private final static Tetrimino2DFactory tetriminoFactory = new Tetrimino2DFactory();

    private TetrisGameController controller;

    @Override
    public void execute(TetrisGameController controller) {
        this.controller = controller;
        resetGame();
        startGame();
    }

    private void resetGame() {
        controller.getGameTimer().resetTimer();
        controller.setGameBoardModel(new TetrisGameBoardModel());
        controller.setActualTetrimino(tetriminoFactory.createRandomTetrimino());
        controller.getActualTetrimino().move(Dimensions.AXIS_Y.getValue(), OFFSET_TO_MIDDLE_COLUMN);
        controller.setNextTetrimino(tetriminoFactory.createRandomTetrimino());
        controller.setPointsAmount(0);
    }

    private void startGame() {
        controller.getGameTimer().start();
        EventDispatcher.getInstance().sendEvent(controller, "updateView");
    }
}
