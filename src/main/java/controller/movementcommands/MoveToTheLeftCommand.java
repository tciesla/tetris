package controller.movementcommands;

import models.point.Dimensions;
import models.tetrimino.ITetrimino;

public class MoveToTheLeftCommand implements MovementCommand {

    @Override
    public void execute(ITetrimino tetrimino) {
        tetrimino.moveBackward(Dimensions.AXIS_Y.getValue());
    }

    @Override
    public void restore(ITetrimino tetrimino) {
        tetrimino.moveForward(Dimensions.AXIS_Y.getValue());
    }
}
