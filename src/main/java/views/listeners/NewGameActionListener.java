package views.listeners;

import controller.EventDispatcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        EventDispatcher.getInstance().sendEvent(this, "newGame");
    }
}
