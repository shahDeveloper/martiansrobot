package martian.robot;


import static martian.robot.RobotConstants.*;

public class MoveForward extends MoveStrategy
{
    @Override
    public char move(char orientation) {
        switch (orientation) {
            case N : return W;
            case W : return S;
            case S : return E;
            case E : return N;
            default: return orientation;
        }

     //   return orientation;
    }
}
