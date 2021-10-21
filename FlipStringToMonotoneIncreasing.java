// MEDIUM - https://leetcode.com/problems/flip-string-to-monotone-increasing/

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int result = 0;
        int count_one = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') {
                count_one++;
            } else {
                result++;
                result = Math.min(result, count_one);
            }
        }
        return result;
    }

}
