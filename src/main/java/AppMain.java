import controller.EventDispatcher;
import controller.TetrisGameController;
import views.window.WindowView;

public class AppMain {

	public static void main(String[] args) {
        new TetrisGameController();
        WindowView windowView = new WindowView();
        EventDispatcher.getInstance().sendEvent(windowView, "newGame");
	}
}
