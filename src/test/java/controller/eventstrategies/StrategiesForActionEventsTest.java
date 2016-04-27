package controller.eventstrategies;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StrategiesForActionEventsTest {

    @Test
    public void shouldReturnMoveToTheRightStrategy() {
        // when
        EventStrategy strategy = StrategiesForActionEvents.getStrategy("moveToTheRight");
        // then
        assertTrue(strategy instanceof MoveToTheRightEventStrategy);
    }

    @Test
    public void shouldReturnNullEventStrategyIfEventNameNotExists() {
        // when
        EventStrategy strategy = StrategiesForActionEvents.getStrategy("impossible1234");
        // then
        assertTrue(strategy instanceof NullEventStrategy);
    }
}