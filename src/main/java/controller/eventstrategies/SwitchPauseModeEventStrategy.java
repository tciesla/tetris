package controller.eventstrategies;

import controller.TetrisGameController;

import javax.swing.*;

public class SwitchPauseModeEventStrategy implements EventStrategy {

    @Override
    public void execute(TetrisGameController controller) {
        Timer gameTimer = controller.getGameTimer();
        if (gameTimer.isRunning()) {
            gameTimer.stop();
        } else {
            gameTimer.start();
        }
    }
}
