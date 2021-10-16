public class CountBinarySubstrings {

    public int CountBinarySubstrings(String s) {
        int curr = 1;
        int prev = 0;
        int total = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                curr++;
            } else {
                total += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        return total + Math.min(curr, prev);
    }

}
