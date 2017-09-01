/**
 * Class to calculate the score of a bowling game
 */
public class Bowling {

    /**
     * Calculates the score of a bowling game
     * @param frames the frames of the game represented as a string
     *               Assumes only valid bowling inputs are given
     * @return the final score of the game
     */
    public static int score(String frames) {
        int score = 0;
        boolean spare = false;
        boolean strike = false;
        for(int i = 0; i < frames.length(); i++) {
            if (frames.charAt(i) != '-' && frames.charAt(i) != ' ') {
                if (frames.charAt(i) == '/') {
                    score += 10 - Integer.parseInt(Character.toString(frames.charAt(i - 1)));
                    if (spare) {
                        score += 10 - Integer.parseInt(Character.toString(frames.charAt(i - 1)));
                    }
                    spare = true;
                } else if (frames.charAt(i) == 'X') {
                    score += 10;
                    if (spare || strike) {
                        score += 10;
                    }
                    if (spare && strike) {
                        score += 10;
                    }
                    if (strike) {
                        spare = true;
                    } else {
                        spare = false;
                    }
                    strike = true;
                } else {
                    score += Integer.parseInt(Character.toString(frames.charAt(i)));
                    if (spare || strike) {
                        score += Integer.parseInt(Character.toString(frames.charAt(i)));
                        if (spare) {
                            spare = false;
                        } else if (strike) {
                            strike = false;
                            spare = true;
                        }
                    }
                }
            }
        }
        return score;
    }

}
