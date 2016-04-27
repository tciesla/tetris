package controller.eventstrategies;

import controller.MovementNotPossibleException;
import controller.TetrisGameController;
import controller.movementcommands.RotateCommand;
import lombok.extern.log4j.Log4j;

@Log4j
public class RotateEventStrategy implements EventStrategy {

    @Override
    public void execute(TetrisGameController controller) {
        try {
            controller.getExecutor().executeMovementCommand(new RotateCommand());
        } catch (MovementNotPossibleException e) {
            log.info("Cannot execute rotation command.");
        }
    }
}
