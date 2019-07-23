package martian.robot;

import static martian.robot.RobotConstants.*;

public class MoveRight extends MoveStrategy {

    @Override
    public void move(Robot robot) {
        char orientation = robot.getPosition().getOrientation();
        RobotPosition position = robot.getPosition();

        switch (orientation) {
            case N:
                position.setOrientation(E);
                break;
            case S:
                position.setOrientation(W);
                break;
            case W:
                position.setOrientation(N);
                break;
            case E:
                position.setOrientation(S);
                break;
        }
    }
}
