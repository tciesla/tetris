package views.row;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameRowView extends JPanel {

    private List<JButton> fields = new ArrayList<JButton>();

    public GameRowView(int columnsAmount) {
        setLayout(new GridLayout(1, columnsAmount));
        fillRowWithFields(columnsAmount);
    }

    private void fillRowWithFields(int columnsAmount) {
        for (int column = 0; column < columnsAmount; column++) {
            fields.add(FieldFactory.createField());
            add(fields.get(column));
        }
    }

    public int getColumnsAmount() {
        return fields.size();
    }

    public JButton getField(int fieldIndex) {
        return fields.get(fieldIndex);
    }

    public void clear() {
        for (JButton field : fields) {
            field.setBackground(Color.WHITE);
        }
    }
}
