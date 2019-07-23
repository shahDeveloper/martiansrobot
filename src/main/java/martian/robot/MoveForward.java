package martian.robot;

import static martian.robot.RobotConstants.*;

public class MoveForward extends MoveStrategy {
    @Override
    public void move(Robot robot) {
        char orientation = robot.getPosition().getOrientation();
        RobotPosition position = robot.getPosition();

        switch (orientation) {
            case E :
                position.setX(position.getX()+1);
                break;
            case W:
                position.setX(position.getX()-1);
                break;
            case N:
                position.setY(position.getY()+1);
                break;
            case S:
                position.setY(position.getY()-1);
                break;
        }
    }
}
