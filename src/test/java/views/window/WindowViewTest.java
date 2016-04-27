package views.window;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindowViewTest {

    @Test
    public void shouldCreateGUIComponents() {
        // when
        WindowView view = new WindowView();
        // then
        Assert.assertNotNull(view.menuBar);
        Assert.assertNotNull(view.northPanel);
        Assert.assertNotNull(view.board);
    }

    @Test
    public void shouldAddGUIComponentsToWindow() {
        // when
        WindowView view = new WindowView();
        // then
        assertNotNull(view.menuBar.getParent());
        assertNotNull(view.northPanel.getParent());
        assertNotNull(view.board.getParent());
    }

    @Test
    public void shouldAddKeyListenerToWindow() {
        // when
        WindowView view = new WindowView();
        // then
        assertEquals(1, view.getKeyListeners().length);
    }

    @Test
    public void shouldSetWindowProperties() {
        // when
        WindowView view = new WindowView();
        // then
        assertFalse(view.isResizable());
        assertTrue(view.isVisible());
    }
}