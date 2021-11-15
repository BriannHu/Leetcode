// MEDIUM - https://leetcode.com/problems/connecting-cities-with-minimum-cost/

import java.util.Arrays;

public class ConnectingCitiesWithMinCost {

    int total;
    int[] data;

    public int minimumCost(int n, int[][] connections) {
        data = new int[n+1];
        total = n;

        for (int i = 0; i <= n; i++) {
            data[i] = i;
        }

        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int cost = 0;

        for (int[] connection : connections) {
            int src = connection[0];
            int des = connection[1];
            if (find(src) != find(des)) {
                cost += connection[2];
                union(src, des);
            }
        }

        return total == 1 ? cost : -1;
    }

    public int find(int x) {
        while (x != data[x]) {
            data[x] = data[data[x]];
            x = data[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            data[px] = py;
            total--;
        }
    }

}
