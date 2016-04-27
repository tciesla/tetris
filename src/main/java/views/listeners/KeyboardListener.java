package views.listeners;

import controller.EventDispatcher;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent event) {}

    @Override
    public void keyPressed(KeyEvent event) {
        String eventName = KeyCodesToEventNamesMapper.getEventName(event.getKeyCode());
        if (eventName != null) {
            EventDispatcher.getInstance().sendEvent(this, eventName);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {}
}
