// MEDIUM - https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

public class UniquePaths {

    // Optimized to one row
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

      // Optimized to two rows
//    public int uniquePaths(int m, int n) {
//        int[] prev = new int[n];
//        int[] curr = new int[n];
//
//        Arrays.fill(prev, 1);
//        Arrays.fill(curr, 1);
//
//        for (int i=1; i<m; i++) {
//            for (int j=1; j<n; j++) {
//                curr[j] = prev[j] + curr[j-1];
//            }
//            int[] temp = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev[n-1];
//    }

      // Naive DP solution
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//
//        for (int[] row: dp) {
//            Arrays.fill(dp, 1);
//        }
//
//        for (int i=1; i<m; i++) {
//            for (int j=1; j<n; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }

}
