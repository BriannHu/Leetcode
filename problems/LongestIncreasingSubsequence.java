package problems;// MEDIUM - https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence {

    public static int LongestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        int best = 1;
        dp[0] = 1;
        for (int i=1; i<nums.length; i++) {
            int max = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j]+1, max);
                }
            }

            dp[i] = max;
            best = Math.max(best, max);
        }
        return best;
    }

}
