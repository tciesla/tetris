package models.board;

import models.tetrimino.ITetrimino;
import models.tetrimino.Tetrimino2DFactory;
import models.tetrimino.TetriminoType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardModelTest {

    private GameBoardModel gameBoard;
    private BoardLimitsValidator limitsValidator;
    private Tetrimino2DFactory tetrimino2DFactory;
    private ITetrimino tetriminoI;

    @Before
    public void setUp() throws Exception {
        limitsValidator = new BoardLimitsValidator(0, 10, 0, 20);
        gameBoard = new GameBoardModel(limitsValidator);
        tetrimino2DFactory = new Tetrimino2DFactory();
        tetriminoI = tetrimino2DFactory.createTetrimino(TetriminoType.I_2D);
    }

    @Test
    public void shouldCreateGameBoard() {
        // when
        GameBoardModel gameBoard = new GameBoardModel(limitsValidator);
        // then
        assertNotNull(gameBoard);
        assertNotNull(gameBoard.tetriminoes);
    }

    @Test
    public void shouldAddTetriminoToGameBoard() {
        // given
        ITetrimino tetrimino = tetrimino2DFactory.createRandomTetrimino();
        // when
        boolean added = gameBoard.add(tetrimino);
        // then
        assertTrue(added);
        assertTrue(gameBoard.contains(tetrimino));
    }

    @Test
    public void shouldRemoveTetriminoFromBoard() {
        // given
        ITetrimino tetrimino = tetrimino2DFactory.createRandomTetrimino();
        gameBoard.add(tetrimino);
        // when
        gameBoard.remove(tetrimino);
        // then
        assertFalse(gameBoard.contains(tetrimino));
    }

    @Test
    public void shouldContainAddedTetrimino() {
        // given
        ITetrimino tetrimino = tetrimino2DFactory.createRandomTetrimino();
        gameBoard.add(tetrimino);
        // when
        boolean containsTetrimino = gameBoard.contains(tetrimino);
        // then
        assertTrue(containsTetrimino);
    }

    @Test
    public void shouldNotContainNotAddedTetrimino() {
        // given
        ITetrimino tetrimino = tetrimino2DFactory.createRandomTetrimino();
        // when
        boolean containsTetrimino = gameBoard.contains(tetrimino);
        // then
        assertFalse(containsTetrimino);
    }

    @Test
    public void shouldAddBePossibleWithXMaxLimit1() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 2, 0, 10);
        gameBoard = new GameBoardModel(validator);
        // when
        gameBoard.add(tetriminoI);
        // then
        assertTrue(gameBoard.contains(tetriminoI));
    }

    @Test
    public void shouldAddNotBePossibleWithYMaxLimit3() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(0, 10, 0, 3);
        gameBoard = new GameBoardModel(validator);
        // when
        gameBoard.add(tetriminoI);
        // then
        assertFalse(gameBoard.contains(tetriminoI));
    }

    @Test
    public void shouldAddNotBePossibleWithXMinLimit2() {
        // given
        BoardLimitsValidator validator = new BoardLimitsValidator(2, 10, 0, 3);
        gameBoard = new GameBoardModel(validator);
        // when
        gameBoard.add(tetriminoI);
        // then
        assertFalse(gameBoard.contains(tetriminoI));
    }
}
