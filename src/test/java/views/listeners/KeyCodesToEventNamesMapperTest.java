package views.listeners;

import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class KeyCodesToEventNamesMapperTest {

    @Test
    public void shouldReturnMoveToNextRowEventName() {
        // when
        String eventName = KeyCodesToEventNamesMapper.getEventName(KeyEvent.VK_DOWN);
        // then
        assertEquals("moveToNextRow", eventName);
    }

    @Test
    public void shouldReturnNullIfKeyCodeIsNotDefined() {
        // when
        String eventName = KeyCodesToEventNamesMapper.getEventName(123456);
        // then
        assertNull(eventName);
    }
}