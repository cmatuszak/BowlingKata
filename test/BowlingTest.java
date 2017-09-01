import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for calculating the score of a bowling game
 * Assume that only valid inputs for a game are given
 */
public class BowlingTest {

    @Test
    public void testAllMisses() {
        Assert.assertEquals(0, Bowling.score("-- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testOneInFirstRollRestMisses() {
        Assert.assertEquals(1, Bowling.score("1- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testTwoInFirstRollRestMisses() {
        Assert.assertEquals(2, Bowling.score("2- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testTwoRollsRestMisses() {
        Assert.assertEquals(3, Bowling.score("12 -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testFullRandomGameWithNoSpecialRolls() {
        Assert.assertEquals(65, Bowling.score("12 3- 45 81 43 -2 52 81 9- -7"));
    }

    @Test
    public void testSpareWithMissNextRoll() {
        Assert.assertEquals(10, Bowling.score("1/ -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testSpareWith1NextRoll() {
        Assert.assertEquals(12, Bowling.score("1/ 1- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testSpareWith12NextFrame() {
        Assert.assertEquals(14, Bowling.score("1/ 12 -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testSingleStrike() {
        Assert.assertEquals(10, Bowling.score("X -- -- -- -- -- -- -- -- --"));
    }

}
