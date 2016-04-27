package views.listeners;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;

public class AboutActionListenerTest {

    @Test
    public void shouldHandleClickEvent() {
        // given
        String message = "text";
        AboutActionListener listener = spy(new AboutActionListener());
        when(listener.createMessage()).thenReturn(message);
        doNothing().when(listener).createMessageDialog(message);
        JMenuItem menuItem = mock(JMenuItem.class);
        // when
        listener.actionPerformed(new ActionEvent(menuItem, 0, null));
        // then
        verify(listener).createMessage();
        verify(listener).createMessageDialog(message);
    }
}
