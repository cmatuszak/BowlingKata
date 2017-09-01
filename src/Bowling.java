/**
 * Class to calculate the score of a bowling game
 */
public class Bowling {

    public static int score(String frames) {
        if (frames.charAt(0) != '-') {
            return Integer.parseInt(Character.toString(frames.charAt(0)));
        } else {
            return 0;
        }
    }
}
