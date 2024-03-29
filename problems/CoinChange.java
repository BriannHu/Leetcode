package problems;// MEDIUM - https://leetcode.com/problems/coin-change/

public class CoinChange {

    public static int CoinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] != -1) {
                    min = Math.min(min, dp[i-coin]);
                }
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }

        }

        return dp[amount];
    }

}
