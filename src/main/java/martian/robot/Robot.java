package martian.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Robot {

    private static final int gridXLimit = 5;
    private static final int gridYLimit = 3;
    private static List<RobotPosition> dangerousPositions = new ArrayList<>(); // if in this position and instruction is F, ignore it.

    public boolean isMoveDangerous(RobotPosition position, List<RobotPosition> positions) {
        return positions.contains(position);
    }

    //check to make sure Robot doesn't go beyond the grid
    private boolean isRobotLost(RobotPosition position) {

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

    public Optional<String> goRobot(List<String> inputList) {

        int posX = 5;
        int posY = 3;

        Optional<String> output = Optional.empty();

        if (inputList.size() != 2) return output; // if more than 2 lines instruction is given

        String [] positionArr = inputList.get(0).split("\\s");
        char [] moves = inputList.get(1).toCharArray();

        if (positionArr.length != 3 || moves.length > 100) { //incorrect input
            return output;
        }

        posX = Integer.parseInt(positionArr[0]);
        posY = Integer.parseInt(positionArr[1]);
        char currentOrientation = positionArr[2].toCharArray()[0];

        RobotPosition position = new RobotPosition(posX, posY, currentOrientation);


        for (char move : moves) {
            if (move == RobotConstants.L) {
                //  currentOrientation = new MoveLeft().move(currentOrientation);
                MoveStrategy strategy = new MoveLeft();
                char newOrientation = strategy.move(position.getOrientation());
                position.setOrientation(newOrientation);
                continue;
            }
            if (move == RobotConstants.R) {
                // currentOrientation = new MoveRight().move(currentOrientation);
                MoveStrategy strategy = new MoveRight();
                char newOrientation = strategy.move(position.getOrientation());
                position.setOrientation(newOrientation);
                continue;
            }
            if (move == RobotConstants.F) {

                if (isMoveDangerous(position, dangerousPositions)) return Optional.of("Robot can scent danger! It did not move");

                if (isRobotLost(position)) {
                    dangerousPositions.add(position);
                    return Optional.of(position.toString().concat(" LOST"));
                }

                switch (position.getOrientation()) {
                    case RobotConstants.E :
                       // posX += 1;
                        position.setX(position.getX()+1);
                        break;
                    case RobotConstants.W:
                       // posX -= 1;
                        position.setX(position.getX()-1);
                        break;
                    case RobotConstants.N:
                        position.setY(position.getY()+1);
                       // posY += 1;
                        break;
                    case RobotConstants.S:
                        position.setY(position.getY()-1);
                       // posY -= 1;
                        break;
                }
            }
        }
/*
        StringJoiner sj = new StringJoiner(" ");
        sj.add(String.valueOf(posX));
        sj.add(String.valueOf(posY));
        sj.add(String.valueOf(currentOrientation));*/

        return Optional.of(position.toString());
    }

            // 1 1 E
            //RFRFRFRF
   /* private String moveRobot(MoveStrategy strategy) {
        strategy.move(instruction);
        return null;
    }*/
    /*private String moveRobot(String orientation) {
            switch (orientation) {
                case NORTH :
                    orientation = WEST;
                    break;
                case WEST :
                    orientation = SOUTH;
                    break;
                case SOUTH :
                    orientation = EAST;
                    break;
                case EAST :
                    orientation = NORTH;
                    break;
            }

            return orientation;
    }
*/

}
