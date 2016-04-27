package models.point.strategy;

import models.point.IPoint;
import org.codehaus.jackson.JsonNode;

public abstract class ICreatePointStrategy {

    public abstract IPoint createPoint(JsonNode coordinates);

    int createPointInDimension(JsonNode coordinates, int dimension) {
        int indexOfDimension = dimension - 1;
        return coordinates.get(indexOfDimension).getIntValue();
    }
}
