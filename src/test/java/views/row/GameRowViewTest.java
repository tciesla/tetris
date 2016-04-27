package views.row;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameRowViewTest {

    @Test
    public void shouldCreateRowWith10Columns() {
        // when
        GameRowView row = new GameRowView(10);
        // then
        assertEquals(10, row.getColumnsAmount());
    }

    @Test
    public void shouldCreateRowWith15Columns() {
        // when
        GameRowView row = new GameRowView(15);
        // then
        assertEquals(15, row.getColumnsAmount());
    }

    @Test
    public void shouldReturnThirdFieldFromRow() {
        // given
        GameRowView row = new GameRowView(10);
        // when
        JButton field = row.getField(2);
        // then
        assertNotNull(field);
    }

    @Test
    public void shouldClearRowWithWhiteBackground() {
        // given
        GameRowView row = new GameRowView(10);
        row.getField(2).setBackground(Color.PINK);
        row.getField(0).setBackground(Color.YELLOW);
        row.getField(9).setBackground(Color.DARK_GRAY);
        // when
        row.clear();
        // then
        for (int i = 0; i < row.getColumnsAmount(); i++) {
            assertEquals(Color.WHITE, row.getField(i).getBackground());
        }
    }
}
