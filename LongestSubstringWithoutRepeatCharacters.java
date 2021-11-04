// MEDIUM - https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;

public class LongestSubstringWithoutRepeatCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int j = 0; // left pointer
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }

}
