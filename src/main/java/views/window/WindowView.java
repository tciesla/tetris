package views.window;

import views.board.TetrisGameBoardView;
import views.listeners.KeyboardListener;
import views.menubar.MenuBarView;
import views.northpanel.NorthPanelView;

import javax.swing.*;
import java.awt.*;

public class WindowView extends JFrame {

    MenuBarView menuBar = new MenuBarView();
    NorthPanelView northPanel = new NorthPanelView();
    TetrisGameBoardView board = new TetrisGameBoardView();

    public WindowView() {
        setJMenuBar(menuBar);
        add(northPanel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        addKeyListener(new KeyboardListener());
        setWindowProperties();
    }

    private void setWindowProperties() {
        pack();
        setTitle("Tetris Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
