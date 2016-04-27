package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerCallsListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        EventDispatcher.getInstance().sendEvent(this, "moveToNextRow");
    }
}
