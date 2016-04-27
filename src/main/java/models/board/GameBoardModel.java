package models.board;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import lombok.Getter;
import models.tetrimino.ITetrimino;

import java.util.ArrayList;
import java.util.List;

public class GameBoardModel {

    private final static int ROWS = 20;
    private final static int COLUMNS = 10;

    BoardLimitsValidator limitsValidator;
    @Getter List<ITetrimino> tetriminoes = new ArrayList<ITetrimino>();

    public GameBoardModel() {
        limitsValidator = new BoardLimitsValidator(0, ROWS, 0, COLUMNS);
    }

    public GameBoardModel(BoardLimitsValidator limitsValidator) {
        this.limitsValidator = limitsValidator;
    }

    public boolean add(ITetrimino tetrimino) {
        if (isAddTetriminoToBoardPossible(tetrimino)) {
            tetriminoes.add(tetrimino);
            return true;
        }
        return false;
    }

    boolean isAddTetriminoToBoardPossible(ITetrimino tetriminoToAdd) {
        return !isCollision(tetriminoToAdd) && !limitsValidator.isOutsideTheLimits(tetriminoToAdd);
    }

    boolean isCollision(final ITetrimino tetriminoToAdd) {
        List<ITetrimino> collisions = Lists.newArrayList(Collections2.filter(tetriminoes, new Predicate<ITetrimino>() {
            @Override
            public boolean apply(ITetrimino tetrimino) {
                return tetrimino.isCollisionWith(tetriminoToAdd);
            }
        }));
        return collisions.size() > 0;
    }

    public void remove(ITetrimino tetrimino) {
        tetriminoes.remove(tetrimino);
    }

    public boolean contains(ITetrimino tetrimino) {
        return tetriminoes.contains(tetrimino);
    }
}
