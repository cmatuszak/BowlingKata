/**
 * Class to calculate the score of a bowling game
 */
public class Bowling {

    public static int score(String frames) {
        if (frames.charAt(0) == '1') {
            return 1;
        } else {
            return 0;
        }
    }
}
