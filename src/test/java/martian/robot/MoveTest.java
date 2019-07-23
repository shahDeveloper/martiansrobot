package martian.robot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Unit test for simple App.
 */

public class MoveTest {

    @Test
    public void moveForwardTestE() {
        RobotPosition position = new RobotPosition(3, 2, 'E');
        Robot robot = new Robot(new MoveForward(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getX(), 4);
    }

    @Test
    public void moveForwardTestN() {
        RobotPosition position = new RobotPosition(3, 2, 'N');
        Robot robot = new Robot(new MoveForward(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getY(), 3);
    }


    @Test
    public void moveForwardTestW() {
        RobotPosition position = new RobotPosition(3, 2, 'W');
        Robot robot = new Robot(new MoveForward(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getX(), 2);
    }

    @Test
    public void moveForwardTestS() {
        RobotPosition position = new RobotPosition(3, 2, 'S');
        Robot robot = new Robot(new MoveForward(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getY(), 1);
    }

    @Test
    public void moveRightTestN(){
        RobotPosition position = new RobotPosition(3, 2, 'N');
        Robot robot = new Robot(new MoveRight(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'E');
    }


    @Test
    public void moveRightTestS(){
        RobotPosition position = new RobotPosition(3, 2, 'S');
        Robot robot = new Robot(new MoveRight(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'W');
    }


    @Test
    public void moveRightTestE(){
        RobotPosition position = new RobotPosition(3, 2, 'E');
        Robot robot = new Robot(new MoveRight(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'S');
    }


    @Test
    public void moveRightTestW(){
        RobotPosition position = new RobotPosition(3, 2, 'W');
        Robot robot = new Robot(new MoveRight(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'N');
    }

    @Test
    public void moveLeftTestN(){
        RobotPosition position = new RobotPosition(3, 2, 'N');
        Robot robot = new Robot(new MoveLeft(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'W');
    }

    @Test
    public void moveLeftTestS(){
        RobotPosition position = new RobotPosition(3, 2, 'S');
        Robot robot = new Robot(new MoveLeft(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'E');
    }

    @Test
    public void moveLeftTestE(){
        RobotPosition position = new RobotPosition(3, 2, 'E');
        Robot robot = new Robot(new MoveLeft(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'N');
    }

    @Test
    public void moveLeftTestW(){
        RobotPosition position = new RobotPosition(3, 2, 'W');
        Robot robot = new Robot(new MoveLeft(), position);
        robot.move();

        Assert.assertEquals(robot.getPosition().getOrientation(), 'S');
    }
}
