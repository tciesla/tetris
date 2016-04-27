package controller;

import controller.eventstrategies.EventStrategy;
import controller.eventstrategies.StrategiesForActionEvents;
import lombok.Getter;
import lombok.Setter;
import models.board.GameTimerModel;
import models.board.TetrisGameBoardModel;
import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino2DFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TetrisGameController implements ActionListener {

    @Getter @Setter GameTimerModel gameTimer = new GameTimerModel(new TimerCallsListener());
    @Getter @Setter TetrisGameBoardModel gameBoardModel = new TetrisGameBoardModel();
    @Getter @Setter ITetrimino actualTetrimino = new Tetrimino2DFactory().createRandomTetrimino();
    @Getter @Setter ITetrimino nextTetrimino = new Tetrimino2DFactory().createRandomTetrimino();
    @Getter @Setter MovementCommandExecutor executor = new MovementCommandExecutor(this);
    @Getter @Setter int pointsAmount = 0;

    public TetrisGameController() {
        EventDispatcher.getInstance().registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        EventStrategy strategy = StrategiesForActionEvents.getStrategy(event.getActionCommand());
        strategy.execute(this);
    }

    public List<ITetrimino> getTetriminoes() {
        return gameBoardModel.getTetriminoes();
    }
}
