package controller.eventstrategies;

import controller.MovementNotPossibleException;
import controller.TetrisGameController;
import controller.movementcommands.MoveToTheRightCommand;
import lombok.extern.log4j.Log4j;

@Log4j
public class MoveToTheRightEventStrategy implements EventStrategy {

    @Override
    public void execute(TetrisGameController controller) {
        try {
            controller.getExecutor().executeMovementCommand(new MoveToTheRightCommand());
        } catch (MovementNotPossibleException e) {
            log.info("Cannot execute move to the right command.");
        }
    }
}
