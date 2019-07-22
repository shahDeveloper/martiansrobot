package martian.robot;

import java.util.Objects;

public class RobotPosition {
    private int x;
    private int y;
    private char orientation;

    public RobotPosition(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RobotPosition)) return false;
        RobotPosition position = (RobotPosition) o;
        return getX() == position.getX() &&
                getY() == position.getY() &&
                getOrientation() == position.getOrientation();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getX(), getY(), getOrientation());
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
       /* return "RobotPosition{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';*/
    }
}
