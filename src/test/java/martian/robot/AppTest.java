package martian.robot;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private List<RobotPosition> positions;

    @Before
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
    }
}
