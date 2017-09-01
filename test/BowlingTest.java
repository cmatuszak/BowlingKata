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

}
