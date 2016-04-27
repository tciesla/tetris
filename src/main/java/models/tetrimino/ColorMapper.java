package models.tetrimino;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorMapper {

    private static Map<String, Color> colors;

    static {
        colors = new HashMap<String, Color>();
        colors.put("cyan", Color.CYAN);
        colors.put("blue", Color.BLUE);
        colors.put("orange", Color.ORANGE);
        colors.put("yellow", Color.YELLOW);
        colors.put("green", Color.GREEN);
        colors.put("magenta", Color.MAGENTA);
        colors.put("red", Color.RED);
    }

    public static Color getColor(String colorName) {
        return colors.get(colorName);
    }
}
