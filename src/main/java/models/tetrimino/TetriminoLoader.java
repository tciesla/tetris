package models.tetrimino;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;
import models.point.IPoint;
import models.point.strategy.ICreatePointStrategy;
import models.point.strategy.StrategiesForCreatingPoints;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class TetriminoLoader implements ITetriminoLoader {

    private static final String TETRIMINOES_FILE = "tetriminoes.json";
    public static final String JSON_TAG_TETRIMINOES = "tetriminoes";
    public static final String JSON_TAG_TETRIMINO_NAME = "name";
    public static final String JSON_TAG_COORDINATES = "coordinates";
    public static final String JSON_TAG_TETRIMINO_COLOR = "color";

    @Getter private Color color;
    @Getter private List<IPoint> points;
    private JsonNode tetriminoesNode;

    public TetriminoLoader() {
        points = new ArrayList<IPoint>();
        tetriminoesNode = createTetriminoesNodeFromJsonFile();
    }

    private JsonNode createTetriminoesNodeFromJsonFile() {
        try {
            return tryToExtractTetriminoesNodeFromJson();
        } catch (IOException e) {
            log.error("During creating tetriminoes node from json file.");
        }
        return null;
    }

    private JsonNode tryToExtractTetriminoesNodeFromJson() throws IOException {
        File tetriminoesFile = new File(TETRIMINOES_FILE);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(tetriminoesFile).findValue(JSON_TAG_TETRIMINOES);
    }

    public void loadTetrimino(String tetriminoName) {
        JsonNode tetriminoNode = findTetriminoNodeWithName(tetriminoName);
        createTetriminoColor(tetriminoNode);
        createTetriminoPoints(tetriminoNode);
    }

    private JsonNode findTetriminoNodeWithName(final String tetriminoName) {
        List<JsonNode> jsonNodes = Lists.newArrayList(tetriminoesNode);
        List<JsonNode> candidates = Lists.newArrayList(Collections2.filter(jsonNodes, new Predicate<JsonNode>() {
            @Override
            public boolean apply(JsonNode tetriminoNode) {
                return tetriminoName.equals(tetriminoNode.get(JSON_TAG_TETRIMINO_NAME).getTextValue());
            }
        }));
        return (candidates.size() > 0) ? candidates.get(0) : null;
    }

    private void createTetriminoColor(@NonNull JsonNode tetriminoNode) {
        color = ColorMapper.getColor(tetriminoNode.get(JSON_TAG_TETRIMINO_COLOR).getTextValue());
    }

    private void createTetriminoPoints(@NonNull JsonNode tetriminoNode) {
        points = Lists.transform(tetriminoNode.findValues(JSON_TAG_COORDINATES), new Function<JsonNode, IPoint>() {
            @Override
            public IPoint apply(JsonNode coordinatesNode) {
                int pointDimension = coordinatesNode.size();
                ICreatePointStrategy strategy = StrategiesForCreatingPoints.getStrategy(pointDimension);
                return strategy.createPoint(coordinatesNode);
            }
        });
    }
}
