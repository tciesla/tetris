package models.tetrimino;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j;
import models.point.IPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Log4j @Accessors(fluent = true)
public class TetriminoBuilder {

    @Setter private Color color;
    private List<IPoint> points;

    private TetriminoBuilder() {
        color = Color.RED;
        points = new ArrayList<IPoint>();
    }

    public static TetriminoBuilder aTetrimino() {
        return new TetriminoBuilder();
    }

    public Tetrimino build() {
        Tetrimino tetrimino = new Tetrimino();
        tetrimino.setColor(color);
        tetrimino.setPoints(points);
        return tetrimino;
    }

    public TetriminoBuilder points(List<IPoint> pointsToCopy) {
        for (IPoint point : pointsToCopy) {
            points.add(point.clone());
        }
        return this;
    }
}
