package views.board;

import models.tetrimino.ITetrimino;
import views.row.GameRowView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardView extends JPanel {

    static final int SPACE = 10;

    int rowsAmount;
    int columnsAmount;
    List<GameRowView> rows;

    public BoardView(int rows, int columns) {
        this.rowsAmount = rows;
        this.columnsAmount = columns;
        this.rows = new ArrayList<GameRowView>();
        setLayout(new GridLayout(rowsAmount, 1));
        setBorder(BorderFactory.createEmptyBorder(SPACE, SPACE, SPACE, SPACE));
        fillBoardWithRows();
    }

    void fillBoardWithRows() {
        for (int row = 0; row < rowsAmount; row++) {
            rows.add(new GameRowView(columnsAmount));
            add(rows.get(row));
        }
    }

    void setBoardWithTetriminoes(List<ITetrimino> tetriminoes) {
        clearBoard();
        for (ITetrimino tetrimino : tetriminoes) {
            showTetrimino(tetrimino);
        }
    }

    void clearBoard() {
        for (GameRowView row : rows) {
            row.clear();
        }
    }

    void showTetrimino(ITetrimino tetrimino) {
        for (int row = 0; row < rows.size(); row++) {
            tetrimino.fillRow(row, rows.get(row));
        }
    }
}
