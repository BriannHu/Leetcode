package problems;// EASY - https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean ContainsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
