package models.tetrimino;

import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static models.tetrimino.TetriminoBuilder.aTetrimino;

@Log4j
public class Tetrimino2DFactory {

    Random random = new Random();
    Map<TetriminoType, ITetrimino> tetriminoesCache = new HashMap<TetriminoType, ITetrimino>();
    ITetriminoLoader tetriminoLoader = new TetriminoLoader();

    public Tetrimino2DFactory() {
        createAllTypesOfTetrimino();
    }

    private void createAllTypesOfTetrimino() {
        for (TetriminoType tetriminoType : TetriminoType.values()) {
            String tetriminoName = TetriminoNamesMapper.getTetriminoName(tetriminoType);
            tetriminoesCache.put(tetriminoType, createSingleTetrimino(tetriminoName));
        }
    }

    Tetrimino createSingleTetrimino(String tetriminoName) {
        tetriminoLoader.loadTetrimino(tetriminoName);
        return aTetrimino()
                .color(tetriminoLoader.getColor())
                .points(tetriminoLoader.getPoints())
                .build();
    }

    public ITetrimino createRandomTetrimino() {
        Object[] types = tetriminoesCache.keySet().toArray();
        TetriminoType randomTetriminoType = (TetriminoType) types[random.nextInt(types.length)];
        return createTetrimino(randomTetriminoType);
    }

    public ITetrimino createTetrimino(TetriminoType tetriminoType) {
        ITetrimino tetrimino = new Rotation2DDecorator(tetriminoesCache.get(tetriminoType));
        return tetrimino.clone();
    }
}
