package views;

import org.junit.Test;
import views.row.FieldFactory;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class FieldFactoryTest {

    @Test
    public void shouldCreateField() {
        // when
        JButton field = FieldFactory.createField();
        // then
        assertNotNull(field);
        assertEquals(Color.WHITE, field.getBackground());
        assertFalse(field.isEnabled());
    }

}