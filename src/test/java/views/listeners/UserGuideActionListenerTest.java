package views.listeners;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class UserGuideActionListenerTest {

    @Test
    public void shouldHandleClickEvent() {
        // given
        String message = "text";
        UserGuideActionListener listener = spy(new UserGuideActionListener());
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