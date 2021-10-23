public class FindMinimuminRotatedSortedArray2 {

    public int findMin(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int l = 0;
        int h = nums.length-1;
        int mid;
        while (l < h) {
            mid = l + (h-l) / 2;
            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                // otherwise will not return correct index of minimum
                if (nums[h - 1] > nums[h]) {
                    l = h;
                    break;
                }
                h--;
            }
        }
        return nums[l];
    }

}
