package models.tetrimino;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TetriminoNamesMapperTest {

    @Test
    public void shouldGetTetriminoIName() {
        // when
        String name = TetriminoNamesMapper.getTetriminoName(TetriminoType.I_2D);
        // then
        assertEquals("Tetrimino2DI", name);
    }

    @Test
    public void shouldGetTetriminoTName() {
        // when
        String name = TetriminoNamesMapper.getTetriminoName(TetriminoType.T_2D);
        // then
        assertEquals("Tetrimino2DT", name);
    }
}