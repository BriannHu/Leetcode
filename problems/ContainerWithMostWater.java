package problems;// MEDIUM - https://leetcode.com/problems/container-with-most-water/

public class ContainerWithMostWater {

    public int ContainerWithMostWater(int[] height) {
        int fp = 0;
        int sp = height.length - 1;
        int max_area = 0;
        while (fp < sp) {
            int current_area = (sp - fp) * Math.min(height[fp], height[sp]);
            max_area = Math.max(current_area, max_area);
            if (height[fp] > height[sp]) {
                sp--;
            } else {
                fp++;
            }
        }
        return max_area;
    }

}
