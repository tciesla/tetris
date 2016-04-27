package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {

    private static EventDispatcher eventDispatcher = new EventDispatcher();

    private List<ActionListener> listeners;

    private EventDispatcher() {
        listeners = new ArrayList<ActionListener>();
    }

    public static EventDispatcher getInstance() {
        return eventDispatcher;
    }

    public void registerListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void sendEvent(Object source, String eventName) {
        ActionEvent event = new ActionEvent(source, 0, eventName);
        for (ActionListener listener : listeners) {
            listener.actionPerformed(event);
        }
    }
}
