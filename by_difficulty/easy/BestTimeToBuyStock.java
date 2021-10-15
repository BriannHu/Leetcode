// EASY - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyStock {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int best_profit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int current_profit = prices[right] - prices[left];
                best_profit = Math.max(current_profit, best_profit);
            } else {
                left = right;
            }
            right++;
        }
        return best_profit;
    }
}
