package views.board;

import controller.TetrisGameController;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class PreviewScreenViewTest {

    @Test
    public void shouldDefaultCreateBoardWithSizes3x4() {
        // when
        PreviewScreenView board = new PreviewScreenView();
        // then
        assertEquals(3, board.rowsAmount);
        assertEquals(4, board.columnsAmount);
    }

    @Test
    public void shouldHandleUpdateViewEvent() {
        // given
        PreviewScreenView view = spy(new PreviewScreenView());
        TetrisGameController controller = new TetrisGameController();
        // when
        view.actionPerformed(new ActionEvent(controller, 0, "updateView"));
        // then
        verify(view).clearBoard();
        verify(view).showTetrimino(controller.getNextTetrimino());
    }
}