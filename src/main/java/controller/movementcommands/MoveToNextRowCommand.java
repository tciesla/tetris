package controller.movementcommands;

import models.point.Dimensions;
import models.tetrimino.ITetrimino;

public class MoveToNextRowCommand implements MovementCommand {

    @Override
    public void execute(ITetrimino tetrimino) {
        tetrimino.moveForward(Dimensions.AXIS_X.getValue());
    }

    @Override
    public void restore(ITetrimino tetrimino) {
        tetrimino.moveBackward(Dimensions.AXIS_X.getValue());
    }
}
