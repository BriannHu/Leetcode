// MEDIUM - https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Arrays;

public class kClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        int l = 0;
        int r = len-1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == k) break;
            if (mid < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    // partitions array so all elements less than l are on left and greater are on right
    public int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && compare(points[r], pivot) >= 0) {
                r--;
            }
            points[l] = points[r];
            while (l < r && compare(points[l], pivot) <= 0) {
                l++;
            }
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }

    public int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}
