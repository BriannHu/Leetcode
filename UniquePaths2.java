// MEDIUM - https://leetcode.com/problems/unique-paths-ii/

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        dp[0] = 1;
        for (int[] row: obstacleGrid) {
            for (int i=0; i<width; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }
        }
        return dp[width-1];
    }

}
