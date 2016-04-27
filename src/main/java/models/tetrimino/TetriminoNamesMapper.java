package models.tetrimino;

import java.util.HashMap;
import java.util.Map;

public class TetriminoNamesMapper {

    private static Map<TetriminoType, String> tetriminoTypes;

    static {
        tetriminoTypes = new HashMap<TetriminoType,String>();
        tetriminoTypes.put(TetriminoType.I_2D, "Tetrimino2DI");
        tetriminoTypes.put(TetriminoType.J_2D, "Tetrimino2DJ");
        tetriminoTypes.put(TetriminoType.L_2D, "Tetrimino2DL");
        tetriminoTypes.put(TetriminoType.O_2D, "Tetrimino2DO");
        tetriminoTypes.put(TetriminoType.S_2D, "Tetrimino2DS");
        tetriminoTypes.put(TetriminoType.T_2D, "Tetrimino2DT");
        tetriminoTypes.put(TetriminoType.Z_2D, "Tetrimino2DZ");
    }

    public static String getTetriminoName(TetriminoType type) {
        return tetriminoTypes.get(type);
    }
}
