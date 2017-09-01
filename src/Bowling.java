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
    public static int score(String input) {
        int score = 0;
        boolean spare = false;
        boolean strike = false;
        String[] frames = input.split(" ");
        for(int i = 0; i < frames.length; i++) {
            for (int j = 0; j < frames[i].length(); j++) {
                if (frames[i].charAt(j) != '-' && frames[i].charAt(j) != ' ') {
                    if (frames[i].charAt(j) == '/') {
                        score += 10 - Integer.parseInt(Character.toString(frames[i].charAt(j - 1)));
                        if (spare && !(i == 9 && j > 0)) {
                            score += 10 - Integer.parseInt(Character.toString(frames[i].charAt(j - 1)));
                        }
                        spare = true;
                    } else if (frames[i].charAt(j) == 'X') {
                        score += 10;
                        if ((spare || strike) && !(i == 9 && j > 0)) {
                            score += 10;
                        }
                        if ((spare && strike) && !(i == 9 && j > 1)) {
                            score += 10;
                        }
                        if (strike) {
                            spare = true;
                        } else {
                            spare = false;
                        }
                        strike = true;
                    } else {
                        score += Integer.parseInt(Character.toString(frames[i].charAt(j)));
                        if ((spare || strike) && !(i == 9 && j > 0)) {
                            score += Integer.parseInt(Character.toString(frames[i].charAt(j)));
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
        }
        return score;
    }

}
