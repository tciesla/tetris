package views.menubar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MenuBarViewTest {

    @Test
    public void shouldAddGUIComponents() {
        // when
        MenuBarView view = new MenuBarView();
        // then
        assertNotNull(view.gameMenu.getParent());
        assertNotNull(view.helpMenu.getParent());
        assertNotNull(view.newGame.getParent());
        assertNotNull(view.exitGame.getParent());
        assertNotNull(view.userGuide.getParent());
        assertNotNull(view.aboutProgram.getParent());
    }

    @Test
    public void shouldAddActionListeners() {
        // when
        MenuBarView view = new MenuBarView();
        // then
        assertEquals(1, view.newGame.getActionListeners().length);
        assertEquals(1, view.exitGame.getActionListeners().length);
        assertEquals(1, view.userGuide.getActionListeners().length);
        assertEquals(1, view.aboutProgram.getActionListeners().length);
    }
}