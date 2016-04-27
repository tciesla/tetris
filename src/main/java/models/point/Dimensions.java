package models.point;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Dimensions {
    AXIS_X(1),
    AXIS_Y(2),
    AXIS_Z(3),
    SECOND_DIMENSION(2);

    @Getter private final int value;
}
