package problems;// EASY - https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {

    public int ClimbingStairs(int n) {
        if (n < 4) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

}
