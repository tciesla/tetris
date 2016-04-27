package views.northpanel;

import controller.TetrisGameController;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class NorthPanelViewTest {

    @Test
    public void shouldAddGUIComponentsToPanel() {
        // when
        NorthPanelView view = new NorthPanelView();
        // then
        assertNotNull(view.pointsLabel.getParent());
        assertNotNull(view.previewScreenForNextTetrimino.getParent());
    }

    @Test
    public void shouldHandleUpdateViewEvent() {
        // given
        NorthPanelView view = spy(new NorthPanelView());
        TetrisGameController controller = new TetrisGameController();
        // when
        view.actionPerformed(new ActionEvent(controller, 0, "updateView"));
        // then
        verify(view).setPointsLabel(controller.getPointsAmount());
    }

    @Test
    public void shouldSetPointsLabelOn25() {
        // given
        NorthPanelView view = new NorthPanelView();
        // when
        view.setPointsLabel(25);
        // then
        assertEquals("Points: 25", view.pointsLabel.getText());
    }
}