package problems;// MEDIUM - https://leetcode.com/problems/perfect-squares/

public class PerfectSquares {

    public int PerfectSquares(int n) {
        int[] dp = new int[n+1];

        for (int i=1; i<=n; i++) {
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (i - j*j >= 0) {
                min = Math.min(min, dp[i-j*j]+1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

}
