package views.board;

import controller.TetrisGameController;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TetrisGameBoardViewTest {

    @Test
    public void shouldDefaultCreateBoardWithSizes20x10() {
        // when
        TetrisGameBoardView board = new TetrisGameBoardView();
        // then
        assertEquals(20, board.rowsAmount);
        assertEquals(10, board.columnsAmount);
    }

    @Test
    public void shouldHandleUpdateViewEvent() {
        // given
        TetrisGameBoardView board = spy(new TetrisGameBoardView());
        TetrisGameController controller = new TetrisGameController();
        // when
        board.actionPerformed(new ActionEvent(controller, 0, "updateView"));
        // then
        verify(board).setBoardWithTetriminoes(controller.getTetriminoes());
    }

}