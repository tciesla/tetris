package models.point;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class PointTest {

    private IPoint point;

    @Before
    public void setUp() throws Exception {
        point = new Point(0, 0, 0);
    }

    @Test
    public void shouldXCoordinateBeEquals5() {
        // when
        IPoint point = new Point(5, 0);
        // then
        assertEquals(5, point.getX());
        assertEquals(0, point.getY());
    }

    @Test
    public void shouldYCoordinateBeEquals5() {
        // when
        IPoint point = new Point(0, 5);
        // then
        assertEquals(0, point.getX());
        assertEquals(5, point.getY());
    }

    @Test
    public void shouldZCoordinateBeEquals0ByDefault() {
        // when
        IPoint point = new Point(5, 5);
        // then
        assertEquals(5, point.getX());
        assertEquals(5, point.getY());
        assertEquals(0, point.getZ());
    }

    @Test
    public void shouldGetXBeEquivalentOfGetCoordinate() {
        // given
        IPoint point = spy(new Point());
        // when
        point.getX();
        // then
        verify(point).getCoordinate(Dimensions.AXIS_X.getValue());
    }

    @Test
    public void shouldGetYBeEquivalentOfGetCoordinate() {
        // given
        IPoint point = spy(new Point());
        // when
        point.getY();
        // then
        verify(point).getCoordinate(Dimensions.AXIS_Y.getValue());
    }

    @Test
    public void shouldGetZBeEquivalentOfGetCoordinate() {
        // given
        IPoint point = spy(new Point());
        // when
        point.getZ();
        // then
        verify(point).getCoordinate(Dimensions.AXIS_Z.getValue());
    }

    @Test
    public void shouldSetXCoordinateOn5() {
        // when
        point.setCoordinate(Dimensions.AXIS_X.getValue(), 5);
        // then
        assertEquals(5, point.getX());
        assertEquals(0, point.getY());
        assertEquals(0, point.getZ());
    }

    @Test
    public void shouldSetYCoordinateOn5() {
        // when
        point.setCoordinate(Dimensions.AXIS_Y.getValue(), 5);
        // then
        assertEquals(0, point.getX());
        assertEquals(5, point.getY());
        assertEquals(0, point.getZ());
    }

    @Test
    public void shouldPoint2DReturnMaxDimension2() {
        // given
        IPoint point = new Point(0, 0);
        // when
        int maxDimensionOfCoordinates = point.getMaximumDimension();
        // then
        assertEquals(2, maxDimensionOfCoordinates);
    }

    @Test
    public void shouldPoint4DReturnMaxDimension4() {
        // given
        IPoint point = new Point(0, 0, 0, 0);
        // when
        int maxDimensionOfCoordinates = point.getMaximumDimension();
        // then
        assertEquals(4, maxDimensionOfCoordinates);
    }

    @Test
    public void shouldClonedPointBeNotThisSame() {
        // when
        IPoint clonedPoint = point.clone();
        // then
        assertNotSame(point, clonedPoint);
    }

    @Test
    public void shouldClonedPointBeEqualsOrigin() {
        // when
        IPoint clonedPoint = point.clone();
        // then
        assertEquals(point, clonedPoint);
    }

    @Test
    public void shouldClonedPointBeEqualsOurselves() {
        // when
        boolean equals = point.equals(point);
        // then
        assertTrue(equals);
    }

    @Test
    public void shouldEquationBeSymmetricForEqualsPoints() {
        // given
        IPoint firstPoint = new Point(5, 0);
        IPoint secondPoint = new Point(5, 0);
        // when
        boolean symmetric = firstPoint.equals(secondPoint) == secondPoint.equals(firstPoint);
        // then
        assertTrue(symmetric);
    }

    @Test
    public void shouldEquationBeSymmetricForNotEqualsPoints() {
        // given
        IPoint firstPoint = new Point(5, 0);
        IPoint secondPoint = new Point(0, 5);
        // when
        boolean symmetric = firstPoint.equals(secondPoint) == secondPoint.equals(firstPoint);
        // then
        assertTrue(symmetric);
    }

    @Test
    public void shouldPointBeNeverEqualsNull() {
        // when
        boolean equals = point.equals(null);
        // then
        assertFalse(equals);
    }

    @Test
    public void shouldPointBeNeverEqualsOtherClass() {
        // when
        boolean equals = point.equals(new String());
        // then
        assertFalse(equals);
    }

    @Test
    public void shouldExamplePoints2DBeEquals() {
        // given
        IPoint firstPoint = new Point(5, 0);
        IPoint secondPoint = new Point(5, 0);
        // when
        boolean equals = firstPoint.equals(secondPoint);
        // then
        assertTrue(equals);
    }

    @Test
    public void shouldExamplePoints3DBeEquals() {
        // given
        IPoint firstPoint = new Point(5, 10, 15);
        IPoint secondPoint = new Point(5, 10, 15);
        // when
        boolean equals = firstPoint.equals(secondPoint);
        // then
        assertTrue(equals);
    }

    @Test
    public void shouldPointsBeNotEquals() {
        // given
        IPoint firstPoint = new Point(5, 0);
        IPoint secondPoint = new Point(0, 5);
        // when
        boolean equals = firstPoint.equals(secondPoint);
        // then
        assertFalse(equals);
    }

    @Test
    public void shouldThisSamePointsHaveThisSameHashCodes() {
        // given
        IPoint firstPoint = new Point(5, 0);
        IPoint secondPoint = new Point(5, 0);
        // when
        boolean equalsHashCodes = firstPoint.hashCode() == secondPoint.hashCode();
        // then
        assertTrue(equalsHashCodes);
    }

    @Test
    public void shouldTetriminoBeInsideMaximalXLimitEquals1() {
        // given
        point = new Point(0, 0);
        // when
        boolean outside = point.isOutsideMaximalLimit(Dimensions.AXIS_X.getValue(), 1);
        // then
        assertFalse(outside);
    }

    @Test
    public void shouldTetriminoBeInsideMaximalYLimitEquals3() {
        // given
        point = new Point(0, 1);
        // when
        boolean outside = point.isOutsideMaximalLimit(Dimensions.AXIS_Y.getValue(), 3);
        // then
        assertFalse(outside);
    }

    @Test
    public void shouldPointBeOutsideMaximalXLimitEquals2() {
        // given
        point = new Point(3, 0);
        // when
        boolean outside = point.isOutsideMaximalLimit(Dimensions.AXIS_X.getValue(), 2);
        // then
        assertTrue(outside);
    }

    @Test
    public void shouldTetriminoBeOutsideMaximalYLimitEquals3() {
        // given
        point = new Point(0, 3);
        // when
        boolean outside = point.isOutsideMaximalLimit(Dimensions.AXIS_Y.getValue(), 3);
        // then
        assertTrue(outside);
    }

    @Test
    public void shouldTetriminoBeInsideMinimalXLimitEquals0() {
        // given
        point = new Point(0, 0);
        // when
        boolean outside = point.isOutsideMinimalLimit(Dimensions.AXIS_X.getValue(), 0);
        // then
        assertFalse(outside);
    }

    @Test
    public void shouldTetriminoBeInsideMinimalYLimitEquals3() {
        // given
        point = new Point(0, 3);
        // when
        boolean outside = point.isOutsideMinimalLimit(Dimensions.AXIS_Y.getValue(), 3);
        // then
        assertFalse(outside);
    }

    @Test
    public void shouldTetriminoBeOutsideMinimalXLimitEquals3() {
        // given
        point = new Point(0, 5);
        // when
        boolean outside = point.isOutsideMinimalLimit(Dimensions.AXIS_X.getValue(), 3);
        // then
        assertTrue(outside);
    }
}