import java.util.HashMap;

// EASY - https://leetcode.com/problems/two-sum/

public class TwoSum {

    public int[] TwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (store.containsKey(nums[i])) {
                return new int[]{store.get(nums[i]), i};
            } else {
                store.put(target-nums[i], i);
            }
        }
        return null;
    }

}
