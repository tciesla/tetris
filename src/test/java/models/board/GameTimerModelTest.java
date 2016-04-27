package models.board;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTimerModelTest {

    @Test
    public void shouldCreateDefaultGameTimerWithDelay500ms() {
        // when
        GameTimerModel timer = new GameTimerModel(null);
        // then
        assertEquals(500, timer.getDelay());
    }

    @Test
    public void shouldCreateGameTimerWithDelay1500ms() {
        // when
        GameTimerModel timer = new GameTimerModel(1500, null);
        // then
        assertEquals(1500, timer.getDelay());
    }

    @Test
    public void shouldDefaultAccelerationPerPointEquals10ms() {
        // when
        GameTimerModel timer = new GameTimerModel(null);
        // then
        assertEquals(10, timer.getAccelerationPerPoint());
    }

    @Test
    public void shouldSetAccelerationPerPointOn5ms() {
        // given
        GameTimerModel timer = new GameTimerModel(null);
        // when
        timer.setAccelerationPerPoint(5);
        // then
        assertEquals(5, timer.getAccelerationPerPoint());
    }

    @Test
    public void shouldUpdateGameTimerWithPointsAmountEquals10() {
        // given
        GameTimerModel timer = new GameTimerModel(1000, null);
        timer.setAccelerationPerPoint(20);
        // when
        timer.updateDelay(10);
        // then
        assertEquals(800, timer.getDelay());
    }

    @Test
    public void shouldUpdateGameTimerWithPointsAmountEquals20() {
        // given
        GameTimerModel timer = new GameTimerModel(1000, null);
        timer.setAccelerationPerPoint(20);
        // when
        timer.updateDelay(20);
        // then
        assertEquals(600, timer.getDelay());
    }

    @Test
    public void shouldFinallyDelayBeEquals0() {
        // given
        GameTimerModel timer = new GameTimerModel(1000, null);
        timer.setAccelerationPerPoint(10);
        // when
        timer.updateDelay(100);
        // then
        assertEquals(0, timer.getDelay());
    }

    @Test
    public void shouldDelayEquals0WhenIsTooManyPoints() {
        // given
        GameTimerModel timer = new GameTimerModel(1000, null);
        timer.setAccelerationPerPoint(10);
        // when
        timer.updateDelay(200);
        // then
        assertEquals(0, timer.getDelay());
    }

    @Test
    public void shouldResetGameTimerOnInitialDefaultDelayEquals500ms() {
        // given
        GameTimerModel timer = new GameTimerModel(null);
        timer.setAccelerationPerPoint(10);
        timer.updateDelay(25);
        // when
        timer.resetTimer();
        // then
        assertEquals(500, timer.getDelay());
    }

    @Test
    public void shouldResetGameTimerOnInitialDelayEquals1000ms() {
        // given
        GameTimerModel timer = new GameTimerModel(1000, null);
        timer.setAccelerationPerPoint(10);
        timer.updateDelay(25);
        // when
        timer.resetTimer();
        // then
        assertEquals(1000, timer.getDelay());
    }
}
