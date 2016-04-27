package views.board;

import controller.EventDispatcher;
import controller.TetrisGameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisGameBoardView extends BoardView implements ActionListener {

    private static final int DEFAULT_ROWS_AMOUNT = 20;
    private static final int DEFAULT_COLUMNS_AMOUNT = 10;

    public TetrisGameBoardView() {
        super(DEFAULT_ROWS_AMOUNT, DEFAULT_COLUMNS_AMOUNT);
        EventDispatcher.getInstance().registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("updateView")) {
            TetrisGameController controller = (TetrisGameController) event.getSource();
            setBoardWithTetriminoes(controller.getTetriminoes());
        }
    }
}
