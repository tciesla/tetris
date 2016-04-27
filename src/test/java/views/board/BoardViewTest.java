package views.board;

import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino2DFactory;
import org.junit.Test;
import views.row.GameRowView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class BoardViewTest {

    @Test
    public void shouldCreateBoardWithSizes100x20() {
        // when
        BoardView board = new BoardView(100, 20);
        // then
        assertEquals(100, board.rowsAmount);
        assertEquals(20, board.columnsAmount);
    }

    @Test
    public void shouldFillBoardWithRows() {
        // when
        BoardView board = new BoardView(20, 10);
        // then
        assertEquals(20, board.rows.size());
        for (GameRowView row : board.rows) {
            assertNotNull(row);
        }
    }

    @Test
    public void shouldClearGameBoard() {
        // given
        BoardView view = new BoardView(20, 10);
        view.rows = new ArrayList<GameRowView>();
        view.rows.add(spy(new GameRowView(10)));
        view.rows.add(spy(new GameRowView(10)));
        view.rows.add(spy(new GameRowView(10)));
        // when
        view.clearBoard();
        // then
        for (GameRowView row : view.rows) {
            verify(row).clear();
        }
    }

    @Test
    public void shouldCall3TimesAddTetriminoToBoard() {
        // given
        BoardView view = spy(new BoardView(20, 10));
        List<ITetrimino> tetriminoes = new ArrayList<ITetrimino>();
        ITetrimino tetrimino1 = new Tetrimino2DFactory().createRandomTetrimino();
        ITetrimino tetrimino2 = new Tetrimino2DFactory().createRandomTetrimino();
        ITetrimino tetrimino3 = new Tetrimino2DFactory().createRandomTetrimino();
        tetriminoes.add(tetrimino1);
        tetriminoes.add(tetrimino2);
        tetriminoes.add(tetrimino3);
        // when
        view.setBoardWithTetriminoes(tetriminoes);
        // then
        verify(view).showTetrimino(tetrimino1);
        verify(view).showTetrimino(tetrimino2);
        verify(view).showTetrimino(tetrimino3);
    }
}