package models.tetrimino;

import models.point.IPoint;

import java.awt.Color;
import java.util.List;

public interface ITetriminoLoader {

    public void loadTetrimino(String tetriminoName);

    public Color getColor();

    public List<IPoint> getPoints();
}
