// EASY - https://leetcode.com/problems/counting-bits/

public class CountBits {

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

}
