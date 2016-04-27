package controller.movementcommands;

import models.tetrimino.ITetrimino;

public interface MovementCommand {
    public void execute(ITetrimino tetrimino);
    public void restore(ITetrimino tetrimino);
}
