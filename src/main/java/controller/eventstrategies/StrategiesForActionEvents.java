package controller.eventstrategies;

import java.util.HashMap;
import java.util.Map;

public class StrategiesForActionEvents {
    private static Map<String, EventStrategy> strategy;

    static {
        strategy = new HashMap<String, EventStrategy>();
        strategy.put("moveToNextRow", new MoveToNextRowEventStrategy());
        strategy.put("moveToLastRow", new MoveToLastRowEventStrategy());
        strategy.put("moveToTheRight", new MoveToTheRightEventStrategy());
        strategy.put("moveToTheLeft", new MoveToTheLeftEventStrategy());
        strategy.put("rotate", new RotateEventStrategy());
        strategy.put("newGame", new NewGameEventStrategy());
        strategy.put("switchPauseMode", new SwitchPauseModeEventStrategy());
    }

    public static EventStrategy getStrategy(String eventName) {
        return strategy.get(eventName) != null ? strategy.get(eventName) : new NullEventStrategy();
    }
}
