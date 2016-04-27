package views.northpanel;

import controller.EventDispatcher;
import controller.TetrisGameController;
import views.board.PreviewScreenView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NorthPanelView extends JPanel implements ActionListener {

    private final static int PANEL_ROWS = 1;
    private final static int PANEL_COLUMNS = 2;
    private final static int SPACE = 10;

    JLabel pointsLabel = new JLabel("Points: 0");
    PreviewScreenView previewScreenForNextTetrimino = new PreviewScreenView();

    public NorthPanelView() {
        EventDispatcher.getInstance().registerListener(this);
        setLayout(new GridLayout(PANEL_ROWS, PANEL_COLUMNS));
        setBorder(BorderFactory.createEmptyBorder(0, SPACE, 0, SPACE));
        add(pointsLabel);
        add(previewScreenForNextTetrimino);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("updateView")) {
            TetrisGameController controller = (TetrisGameController) event.getSource();
            setPointsLabel(controller.getPointsAmount());
        }
    }

    void setPointsLabel(int pointsAmount) {
        pointsLabel.setText("Points: " + pointsAmount);
    }
}
