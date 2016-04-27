package models.board;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameTimerModel extends Timer {

    private int initialDelay = 500;
    @Getter @Setter private int accelerationPerPoint = 10;

    public GameTimerModel(ActionListener listener) {
        super(0, listener);
        setDelay(initialDelay);
    }

    public GameTimerModel(int initialDelay, ActionListener listener) {
        super(initialDelay, listener);
        this.initialDelay = initialDelay;
    }

    public void updateDelay(int pointsAmount) {
        int delay = initialDelay - pointsAmount * accelerationPerPoint;
        setDelay((delay > 0) ? delay : 0);
    }

    public void resetTimer() {
        setDelay(initialDelay);
    }
}
