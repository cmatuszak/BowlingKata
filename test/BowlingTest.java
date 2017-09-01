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

    @Test
    public void testStrikeAfterSpare() {
        Assert.assertEquals(30, Bowling.score("1/ X -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testSingleRollAfterStrike() {
        Assert.assertEquals(12, Bowling.score("X 1- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testTwoRollsAfterStrike() {
        Assert.assertEquals(16, Bowling.score("X 12 -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testThreeRollsAfterStrike() {
        Assert.assertEquals(19, Bowling.score("X 12 3- -- -- -- -- -- -- --"));
    }

    @Test
    public void testSpareAfterStrike() {
        Assert.assertEquals(36, Bowling.score("X 1/ 3- -- -- -- -- -- -- --"));
    }

    @Test
    public void testTwoStrikes() {
        Assert.assertEquals(30, Bowling.score("X X -- -- -- -- -- -- -- --"));
    }

    @Test
    public void testThreeStrikes() {
        Assert.assertEquals(60, Bowling.score("X X X -- -- -- -- -- -- --"));
    }

    @Test
    public void testAllNines() {
        Assert.assertEquals(90, Bowling.score("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }

    @Test
    public void testAllFiveSpares() {
        Assert.assertEquals(150, Bowling.score("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
    }

    @Test
    public void testPerfectGame() {
        Assert.assertEquals(300, Bowling.score("X X X X X X X X X XXX"));
    }

    @Test
    public void testMissesAfterStrike() {
        Assert.assertEquals(15, Bowling.score("X -- 23 -- -- -- -- -- -- --"));
    }

    @Test
    public void testAlmostPerfectGame() {
        Assert.assertEquals(275, Bowling.score("X X X X X X X X X 5/X"));
    }

}
