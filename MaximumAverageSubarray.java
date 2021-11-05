// EASY - https://leetcode.com/problems/maximum-average-subarray-i/

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        int bestSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        bestSum = Math.max(bestSum, currSum);

        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k];
            bestSum = Math.max(bestSum, currSum);
        }

        return (double)bestSum / k;
    }

}
