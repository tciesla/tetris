package models.point.strategy;

import models.point.Dimensions;
import models.point.IPoint;
import models.point.Point;
import org.codehaus.jackson.JsonNode;

public class CreatePoint2DStrategy extends ICreatePointStrategy {

    @Override
    public IPoint createPoint(JsonNode coordinates) {
        int x = createPointInDimension(coordinates, Dimensions.AXIS_X.getValue());
        int y = createPointInDimension(coordinates, Dimensions.AXIS_Y.getValue());
        return new Point(x, y);
    }
}
