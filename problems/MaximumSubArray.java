package problems;// EASY - https://leetcode.com/problems/maximum-subarray/

public class MaximumSubArray {

    public int MaximumSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int current = 0;
        for (int i=0; i<nums.length; i++) {
            if (current < 0) {
                current = 0;
            }
            current += nums[i];
            best = Math.max(best, current);
        }
        return best;
    }

}
