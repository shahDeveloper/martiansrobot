package martian.robot;

import static martian.robot.RobotConstants.*;

public class MoveLeft extends MoveStrategy {

    @Override
    public void move(Robot robot) {
        char orientation = robot.getPosition().getOrientation();
        RobotPosition position = robot.getPosition();

        switch (orientation) {
            case N :
                position.setOrientation(W);
                break;
            case W :
                position.setOrientation(S);
                break;
            case S :
                position.setOrientation(E);
                break;
            case E :
                position.setOrientation(N);
                break;
        }
    }
}
