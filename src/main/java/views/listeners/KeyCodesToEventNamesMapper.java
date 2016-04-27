package views.listeners;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyCodesToEventNamesMapper {

    private static Map<Integer, String> eventNames;

    static {
        eventNames = new HashMap<Integer, String>();
        eventNames.put(KeyEvent.VK_DOWN, "moveToNextRow");
        eventNames.put(KeyEvent.VK_SPACE, "moveToLastRow");
        eventNames.put(KeyEvent.VK_RIGHT, "moveToTheRight");
        eventNames.put(KeyEvent.VK_LEFT, "moveToTheLeft");
        eventNames.put(KeyEvent.VK_UP, "rotate");
    }

    public static String getEventName(int keyCode) {
        return eventNames.get(keyCode);
    }
}
