// HARD - https://leetcode.com/problems/longest-duplicate-substring/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestDuplicateSubstring {

    private static final long q = (1 << 31) - 1;
    private static final long R = 256;

    public String longestDupSubstring(String s) {
        int left = 1;
        int right = s.length() - 1;
        int start = 0;
        int maxLen = 0;

        while (left <= right) {
            int len = left + (right - left) / 2;
            boolean found = false;

            HashMap<Long, List<Integer>> map = new HashMap<>();
            long hash = hash(s, len);

            map.put(hash, new ArrayList<>());
            map.get(hash).add(0);

            long RM = 1l; // means 1 as long instead of int
            for (int i=1; i<len; i++) {
                RM = (R * RM) % q;
            }

            loop:
            for (int i = 1; i + len <= s.length(); i++) {
                hash = (hash + q - RM * s.charAt(i - 1) % q) % q;
                hash = (hash * R + s.charAt(i + len - 1)) % q;
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                } else {
                    for (int j: map.get(hash)) {
                        if (compare(s, i, j, len)) {
                            found = true;
                            start = i;
                            maxLen = len;
                            break loop;
                        }
                    }
                }
                map.get(hash).add(i);
            }
            if (found) {
                left = len + 1;
            } else {
                right = len - 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private long hash(String s, int len) {
        long h = 0;
        for (int i=0; i<len; i++) {
            h = (R * h + s.charAt(i)) % q;
        }
        return h;
    }

    private boolean compare(String s, int i, int j, int len) {
        for (int count=0; count<len; count++) {
            if (s.charAt(i++) != s.charAt(j++)) {
                return false;
            }
        }
        return true;
    }

}
