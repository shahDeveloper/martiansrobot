package martian.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarsSurface {

    private static final int gridXLimit = 5;
    private static final int gridYLimit = 3;
    private static List<RobotPosition> dangerousPositions = new ArrayList<>(); // if in this position and instruction is F, ignore it.

    public Optional<String> callRobot(List<String> inputList) {

        Optional<String> output = Optional.empty();

        if (inputList.size() != 2) return output; // if more than 2 lines instruction is given

        String [] positionArr = inputList.get(0).split("\\s");
        char [] instruction = inputList.get(1).toCharArray();

        if (positionArr.length != 3 || instruction.length > 100) { //incorrect input
            return output;
        }

        int posX = Integer.parseInt(positionArr[0]);
        int posY = Integer.parseInt(positionArr[1]);
        char currentOrientation = positionArr[2].toCharArray()[0];

        RobotPosition position = new RobotPosition(posX, posY, currentOrientation);
        Robot robot = new Robot(position);

        for (char move : instruction) {
            if (move == RobotConstants.L) {
                robot.setMoveStrategy(new MoveLeft());
                robot.move();
                continue;

            } else if (move == RobotConstants.R) {
                robot.setMoveStrategy(new MoveRight());
                robot.move();
                continue;

            } else if (move == RobotConstants.F) {
                if (dangerousPositions.contains(robot.getPosition())) { // if there is scent then don't apply the move.
                    continue;
                }

                /**
                 * If move is dangerous then save the position (leave a scent).
                 * We could apply the actual move but its redundant hence we assume the move which resulted in robot falling off was applied.
                 */
                if (isFDangerous(position)) {
                    dangerousPositions.add(position);
                    return Optional.of(position.toString().concat(" LOST"));
                }

                robot.setMoveStrategy(new MoveForward());
                robot.move();
            }
        }

        return Optional.of(robot.toString());
    }

    //check to make sure Robot doesn't go beyond the grid
    private boolean isFDangerous(RobotPosition position) {

        switch (position.getOrientation()) {
            case RobotConstants.E :
                if (position.getX()+1 > gridXLimit) {
                    return true;
                }
                break;
            case RobotConstants.W :
                if (position.getX()-1 < 0) {
                    return true;
                }
                break;
            case RobotConstants.N :
                if (position.getY()+1 > gridYLimit) {
                    return true;
                }
                break;
            case RobotConstants.S :
                if (position.getY()-1 < 0) {
                    return true;
                }
                break;
        }

        return false;
    }
}
