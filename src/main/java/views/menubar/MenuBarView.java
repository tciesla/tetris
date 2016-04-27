package views.menubar;

import views.listeners.AboutActionListener;
import views.listeners.ExitGameActionListener;
import views.listeners.NewGameActionListener;
import views.listeners.UserGuideActionListener;

import javax.swing.*;

public class MenuBarView extends JMenuBar {

    JMenu gameMenu = new JMenu("Game");
    JMenu helpMenu = new JMenu("Help");

	JMenuItem newGame = new JMenuItem("New game");
	JMenuItem exitGame = new JMenuItem("Exit game");
	JMenuItem userGuide = new JMenuItem("User guide");
	JMenuItem aboutProgram = new JMenuItem("About");

	public MenuBarView() {
        addMenuItemsToMenuBar();
        addMenuItemsActionListeners();
	}

    private void addMenuItemsToMenuBar() {
        add(gameMenu);
        gameMenu.add(newGame);
        gameMenu.add(exitGame);
        add(helpMenu);
        helpMenu.add(userGuide);
        helpMenu.add(aboutProgram);
    }

    private void addMenuItemsActionListeners() {
        newGame.addActionListener(new NewGameActionListener());
        exitGame.addActionListener(new ExitGameActionListener());
        userGuide.addActionListener(new UserGuideActionListener());
        aboutProgram.addActionListener(new AboutActionListener());
    }
}
