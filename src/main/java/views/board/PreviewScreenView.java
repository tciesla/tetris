package views.board;

import controller.EventDispatcher;
import controller.TetrisGameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviewScreenView extends BoardView implements ActionListener {

    private static final int PREVIEW_SCREEN_WIDTH = 4;
    private static final int PREVIEW_SCREEN_HEIGHT = 3;

    public PreviewScreenView() {
        super(PREVIEW_SCREEN_HEIGHT, PREVIEW_SCREEN_WIDTH);
        EventDispatcher.getInstance().registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("updateView")) {
            TetrisGameController controller = (TetrisGameController) event.getSource();
            clearBoard();
            showTetrimino(controller.getNextTetrimino());
        }
    }
}
