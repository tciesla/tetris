package models.board;

import models.point.Dimensions;
import models.point.Point;
import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino2DFactory;
import models.tetrimino.TetriminoType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TetrisGameBoardModelTest {

    private TetrisGameBoardModel gameBoard;
    private Tetrimino2DFactory tetrimino2DFactory;
    private ITetrimino tetriminoI;
    private ITetrimino tetriminoO;

    @Before
    public void setUp() throws Exception {
        gameBoard = new TetrisGameBoardModel();
        tetrimino2DFactory = new Tetrimino2DFactory();
        tetriminoI = tetrimino2DFactory.createTetrimino(TetriminoType.I_2D);
        tetriminoO = tetrimino2DFactory.createTetrimino(TetriminoType.O_2D);
    }

    @Test
    public void shouldRemove1FullRow() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 5, 0, 4);
        gameBoard = new TetrisGameBoardModel(validator);
        gameBoard.add(tetriminoI);
        // when
        int removedRows = gameBoard.removeFullRows();
        // then
        assertEquals(1, removedRows);
        assertFalse(gameBoard.contains(tetriminoI));
    }

    @Test
    public void shouldRemove2FullRows() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 5, 0, 4);
        gameBoard = new TetrisGameBoardModel(validator);
        gameBoard.add(tetriminoI);
        ITetrimino otherTetrimino = tetrimino2DFactory.createTetrimino(TetriminoType.I_2D);
        otherTetrimino.moveForward(Dimensions.AXIS_X.getValue());
        otherTetrimino.moveForward(Dimensions.AXIS_X.getValue());
        gameBoard.add(otherTetrimino);
        // when
        int removedRows = gameBoard.removeFullRows();
        // then
        assertEquals(2, removedRows);
        assertFalse(gameBoard.contains(tetriminoI));
        assertFalse(gameBoard.contains(otherTetrimino));
    }

    @Test
    public void shouldNotRemoveAnyFullRows() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 5, 0, 4);
        gameBoard = new TetrisGameBoardModel(validator);
        gameBoard.add(tetriminoO);
        // when
        int removedRows = gameBoard.removeFullRows();
        // then
        assertEquals(0, removedRows);
        assertTrue(gameBoard.contains(tetriminoO));
    }

    @Test
    public void shouldMoveHigherRowsOneLevelDown() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 5, 0, 4);
        gameBoard = new TetrisGameBoardModel(validator);
        tetriminoI.move(Dimensions.AXIS_X.getValue(), 2);
        gameBoard.add(tetriminoO);
        gameBoard.add(tetriminoI);
        // when
        gameBoard.removeFullRows();
        // then
        assertTrue(tetriminoO.getPoints().contains(new Point(1, 0)));
        assertTrue(tetriminoO.getPoints().contains(new Point(1, 1)));
        assertTrue(tetriminoO.getPoints().contains(new Point(2, 0)));
        assertTrue(tetriminoO.getPoints().contains(new Point(2, 1)));
    }
}