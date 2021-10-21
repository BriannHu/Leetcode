package problems;// EASY - https://leetcode.com/problems/guess-number-higher-or-lower/

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumberHigherOrLower {

    int guess(int n) {
        return n; // dummy method to remove IDE warnings
    }

    public int GuessNumberHigherOrLower(int n) {
        if (guess(n) == 0) return n;
        int l = 0;
        int h = n;
        int current;
        while (true) {
            current = l + (h - l) / 2;
            if (guess(current) == -1) {
                // guess is too high
                h = current;
            } else if (guess(current) == 1) {
                // guess is too low
                l = current;
            } else {
                break;
            }
        }
        return current;
    }
}
