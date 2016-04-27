package controller.eventstrategies;

import controller.MovementNotPossibleException;
import controller.TetrisGameController;
import controller.movementcommands.MoveToTheLeftCommand;
import lombok.extern.log4j.Log4j;

@Log4j
public class MoveToTheLeftEventStrategy implements EventStrategy {

    @Override
    public void execute(TetrisGameController controller) {
        try {
            controller.getExecutor().executeMovementCommand(new MoveToTheLeftCommand());
        } catch (MovementNotPossibleException e) {
            log.info("Cannot execute move to the left command.");
        }
    }
}
