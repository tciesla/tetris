package views.listeners;

import controller.EventDispatcher;

import javax.swing.*;
import java.awt.event.*;

public class UserGuideActionListener implements ActionListener {

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
        String leftArrow = "\u2190";
        String rightArrow = "\u2192";
        String downArrow = "\u2193";
        String upArrow = "\u2191";

        StringBuilder message = new StringBuilder("")
                .append("Keys description:\n")
                .append(leftArrow).append(" move tetrimino to the left\n")
                .append(rightArrow).append(" move tetrimino to the right\n")
                .append(downArrow).append(" move tetrimino to the next row\n")
                .append(upArrow).append(" rotate tetrimino\n")
                .append("(Space) drop tetrimino");
        return message.toString();
    }
}
