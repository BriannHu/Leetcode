// MEDIUM - https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;

public class FourSum2 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int total = 0;
        for (int a: nums1) {
            for (int b: nums2) {
                store.put(a+b, store.getOrDefault(a+b, 0)+1);
            }
        }
        for (int c: nums3) {
            for (int d: nums4) {
                total += store.getOrDefault(-(c+d), 0);
            }
        }
        return total;
    }

}
