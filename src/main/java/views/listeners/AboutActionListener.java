package views.listeners;

import controller.EventDispatcher;

import javax.swing.*;
import java.awt.event.*;

public class AboutActionListener implements ActionListener {

    private static final String PRODUCT_NAME = "aTetris Game";
    private static final String AUTHOR = "Tomasz Cieśla";
    private static final String EMAIL = "ciesla.tomasz.92@gmail.com";

    @Override
    public void actionPerformed(ActionEvent event) {
        EventDispatcher.getInstance().sendEvent(this, "switchPauseMode");
        String message = createMessage();
        createMessageDialog(message);
        EventDispatcher.getInstance().sendEvent(this, "switchPauseMode");
    }

    void createMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message,
                "About program", JOptionPane.PLAIN_MESSAGE);
    }

    String createMessage() {
        StringBuilder message = new StringBuilder("")
                .append("Product name: " + PRODUCT_NAME)
                .append("\nAuthor: " + AUTHOR)
                .append("\nContact: " + EMAIL);
        return message.toString();
    }
}
