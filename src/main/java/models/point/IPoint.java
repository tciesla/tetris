package models.point;

public interface IPoint {

    int getCoordinate(int dimension);

    int getX();

    int getY();

    int getZ();

    void setCoordinate(int dimension, int value);

    int getMaximumDimension();

    IPoint clone();

    boolean equals(Object other);

    void rotation(double angle, IPoint rotationPoint);

    boolean isOutsideMinimalLimit(int dimension, int limit);

    boolean isOutsideMaximalLimit(int dimension, int limit);
}
