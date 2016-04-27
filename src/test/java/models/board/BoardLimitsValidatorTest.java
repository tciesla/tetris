package models.board;

import models.point.Dimensions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardLimitsValidatorTest {

    @Test
    public void shouldCreateBoardLimitsValidatorWith2DimensionalLimits() {
        // when
        BoardLimitsValidator validator = new BoardLimitsValidator(10, 20, 0, 5);
        // then
        assertEquals(10, validator.getMinimalLimit(Dimensions.AXIS_X.getValue()));
        assertEquals(20, validator.getMaximalLimit(Dimensions.AXIS_X.getValue()));
        assertEquals(0, validator.getMinimalLimit(Dimensions.AXIS_Y.getValue()));
        assertEquals(5, validator.getMaximalLimit(Dimensions.AXIS_Y.getValue()));
    }

    @Test
    public void shouldCreateBoardLimitsValidatorWith3DimensionalLimits() {
        // when
        BoardLimitsValidator validator = new BoardLimitsValidator(10, 20, 0, 5, 30, 60);
        // then
        assertEquals(10, validator.getMinimalLimit(Dimensions.AXIS_X.getValue()));
        assertEquals(20, validator.getMaximalLimit(Dimensions.AXIS_X.getValue()));
        assertEquals(0, validator.getMinimalLimit(Dimensions.AXIS_Y.getValue()));
        assertEquals(5, validator.getMaximalLimit(Dimensions.AXIS_Y.getValue()));
        assertEquals(30, validator.getMinimalLimit(Dimensions.AXIS_Z.getValue()));
        assertEquals(60, validator.getMaximalLimit(Dimensions.AXIS_Z.getValue()));
    }
}
