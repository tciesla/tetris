package controller.eventstrategies;

        import controller.MovementNotPossibleException;
        import controller.TetrisGameController;
        import controller.movementcommands.MoveToNextRowCommand;

public class MoveToLastRowEventStrategy implements EventStrategy {

    @Override
    public void execute(TetrisGameController controller) {
        boolean lastRow = false;
        while (!lastRow) {
            try {
                controller.getExecutor().executeMovementCommand(new MoveToNextRowCommand());
            } catch (MovementNotPossibleException e) {
                lastRow = true;
            }
        }
    }
}
