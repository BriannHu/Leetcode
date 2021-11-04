// MEDIUM - https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

import java.util.HashMap;

public class LongestSubstringWithAtMost2DistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            result = Math.max(result, i - left + 1);
        }

        return result;
    }

}
