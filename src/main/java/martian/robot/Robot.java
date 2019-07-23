package martian.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Robot {

    private MoveStrategy moveStrategy;
    private RobotPosition position;

    public Robot(RobotPosition position) {
        this(null, position);
    }

    public Robot(MoveStrategy moveStrategy, RobotPosition position) {
        this.moveStrategy = moveStrategy;
        this.position = position;
    }

    public void move() {
        this.moveStrategy.move(this);
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public RobotPosition getPosition() {
        return position;
    }

    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position.toString();
    }

}
