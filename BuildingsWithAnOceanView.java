// MEDIUM - https://leetcode.com/problems/buildings-with-an-ocean-view/

import java.util.ArrayList;

public class BuildingsWithAnOceanView {

    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = n-1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                list.add(i);
            }
        }

        int idx = 0;
        int[] result = new int[list.size()];
        for (int i = list.size()-1; i >= 0; i--) {
            result[idx++] = list.get(i);
        }

        return result;
    }

}
