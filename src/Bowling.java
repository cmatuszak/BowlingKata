/**
 * Class to calculate the score of a bowling game
 */
public class Bowling {

    /**
     * Calculates the score of a bowling game
     * @param input the frames of the game represented as a string
     *               Assumes only valid bowling inputs are given
     * @return the final score of the game
     */
    public static int score(String input) {
        // total score of the game so far
        int score = 0;
        // how many times we should count the current roll
        int rollMultiplier = 1;
        // do we need to carryover an extra roll from a strike to the next roll
        boolean carryOver = false;
        // frames are separated by a space
        String[] frames = input.split(" ");
        // for each frame
        for(int i = 0; i < frames.length; i++) {
            String frame = frames[i];
            // for each roll in the frame
            for (int j = 0; j < frame.length(); j++) {
                // the value of this roll
                int thisRoll = 0;
                boolean spare = false;
                boolean strike = false;
                // if this roll is a miss, its value is 0
                if (frame.charAt(j) == '-') {
                    thisRoll = 0;
                } else if (frame.charAt(j) == '/') {
                    // if this roll is a spare, then its value is 10 - the previous roll
                    // we know this is safe because a spare can only come in the second roll of a frame
                    thisRoll = 10 - Integer.parseInt(Character.toString(frame.charAt(j - 1)));
                    // if this is not the last frame, set spare to true
                    if (i != 9) {
                        spare = true;
                    }
                } else if (frame.charAt(j) == 'X') {
                    // the value of a strike is 10
                    thisRoll = 10;
                    // if this is not the last frame, set strike to true
                    if (i != 9) {
                        strike = true;
                    }
                } else {
                    // else parse the number value of this roll
                    thisRoll = Integer.parseInt(Character.toString(frame.charAt(j)));
                }
                // add the value of this roll to the score times the number of times we need to count it
                score += thisRoll * rollMultiplier;

                // reset the roll multiplier back to 1
                rollMultiplier = 1;
                // if we need to carryover from a previous strike, add one back to the roll multiplier
                if (carryOver) {
                    rollMultiplier++;
                    carryOver = false;
                }
                // if we had a spare this roll, add one to the roll multiplier
                if (spare) {
                    rollMultiplier++;
                // if we had a strike this roll, add one to the roll multiplier and set the carryOver to true
                } else if (strike) {
                    rollMultiplier++;
                    carryOver = true;
                }
            }
        }
        return score;
    }
}
