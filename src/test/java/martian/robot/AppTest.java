package martian.robot;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    private List<RobotPosition> positions;

    @Test
    public void testCallRobotScent() {
        List<String> inputList = new ArrayList<>();

        inputList.add("2 3 N");
        inputList.add("RLRLF");

        MarsSurface marsSurface = new MarsSurface();
        Optional<String> actualResult = marsSurface.callRobot(inputList);
        Assert.assertEquals( "2 3 N LOST", actualResult.get());


        inputList.clear();
        inputList.add("2 3 N");
        inputList.add("F");

        actualResult = marsSurface.callRobot(inputList);
        Assert.assertEquals("2 3 N", actualResult.get());

    }

    @Test
    public void testCallRobotFMove() {
        List<String> inputList = new ArrayList<>();
        inputList.add("1 1 E");
        inputList.add("RFRFRFRF");

        MarsSurface marsSurface = new MarsSurface();
        Optional<String> actualResult = marsSurface.callRobot(inputList);

        Assert.assertEquals(actualResult.get(), "1 1 E");
    }


    @Test
    public void testCallRobotFallingOff1() {
        List<String> inputList = new ArrayList<>();

        MarsSurface marsSurface = new MarsSurface();
        Optional<String> actualResult = marsSurface.callRobot(inputList);

        inputList.add("3 2 N");
        inputList.add("FRRFLLFFRRFLL");

        actualResult = marsSurface.callRobot(inputList);
        Assert.assertEquals("3 3 N LOST", actualResult.get());

    }

/*    @Before
    public void populate() {
        positions = new ArrayList<>();
        positions.add(new RobotPosition(1, 5, 'N'));
        positions.add(new RobotPosition(2, 6, 'S'));
        positions.add(new RobotPosition(3, 7, 'E'));
        positions.add(new RobotPosition(4, 8, 'W'));
    }

    @Test
    public void testIsDangerousPositionSuccess() {
        RobotPosition position1 = new RobotPosition(1, 5, 'N');
        RobotPosition position2 = new RobotPosition(2, 6, 'S');
        RobotPosition position3 = new RobotPosition(3, 7, 'E');
        RobotPosition position4 = new RobotPosition(4, 8, 'W');

        Assert.assertTrue(positions.contains(position1));
        Assert.assertTrue(positions.contains(position2));
        Assert.assertTrue(positions.contains(position3));
        Assert.assertTrue(positions.contains(position4));
    }

    @Test
    public void testIsDangerousPositionFailure() {
        RobotPosition position1 = new RobotPosition(30, 5, 'N');
        RobotPosition position2 = new RobotPosition(2, 60, 'S');
        RobotPosition position3 = new RobotPosition(3, 7, 'S');
        RobotPosition position4 = new RobotPosition(4, 8, 'X');

        Assert.assertFalse(positions.contains(position1));
        Assert.assertFalse(positions.contains(position2));
        Assert.assertFalse(positions.contains(position3));
        Assert.assertFalse(positions.contains(position4));
    }*/
}
