// MEDIUM - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInSortedArray {

    public int FindMinimumInSortedArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int l = 0;
        int h = nums.length-1;
        int mid;
        while (l < h) {
            mid = l + (h-l) / 2;
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if (nums[l] <= nums[mid] && nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return nums[l];
    }
}
