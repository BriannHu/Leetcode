public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] interval: updates) {
            int start = interval[0];
            int end = interval[1];
            int inc = interval[2];

            result[start] += inc;
            if (end < length-1) {
                result[end+1] -= inc;
            }
        }

        for (int i=1; i<length; i++) {
            result[i] += result[i-1];
        }
        return result;
    }

}
