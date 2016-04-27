package views.row;

import javax.swing.*;
import java.awt.*;

public class FieldFactory {

    static final int FIELD_SIZE = 20;

    public static JButton createField() {
        JButton field = new JButton();
        field.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        field.setEnabled(false);
        return field;
    }
}
