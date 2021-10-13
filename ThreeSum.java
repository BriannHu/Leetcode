import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int fp = i + 1;
            int sp = nums.length - 1;
            while (fp < sp) {
                int sum = nums[i] + nums[fp] + nums[sp];
                if (sum > 0) {
                    sp--;
                } else if (sum < 0) {
                    fp++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[fp], nums[sp]));
                    while (fp < sp && nums[fp] == nums[fp + 1]) fp++;
                    while (fp < sp && nums[sp] == nums[sp - 1]) sp--;
                    fp++;
                    sp--;
                }
            }
        }
        return result;
    }

}
