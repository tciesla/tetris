package controller.movementcommands;

import models.tetrimino.ITetrimino;

public class RotateCommand implements MovementCommand {

    ITetrimino memento;

    @Override
    public void execute(ITetrimino tetrimino) {
        memento = tetrimino.clone();
        tetrimino.rotation();
    }

    @Override
    public void restore(ITetrimino tetrimino) {
        tetrimino.getPoints().clear();
        tetrimino.getPoints().addAll(memento.getPoints());
    }
}
