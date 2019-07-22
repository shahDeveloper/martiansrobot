package martian.robot;

import static martian.robot.RobotConstants.*;

public class MoveRight extends MoveStrategy
{
    @Override
    public char move(char orientation) {
        switch (orientation) {
            case N:
                return E;
            case S:
                return W;
            case W:
                return N;
            case E:
                return S;
            default:
                return orientation;
        }

        //return orientation;
    }
}
