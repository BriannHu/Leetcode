// MEDIUM - https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        int[] data = new int[n];
        for (int i=0; i<n; i++) {
            data[i] = i;
        }
        for (int[] edge: edges) {
            int px = find(data, edge[0]);
            int py = find(data, edge[1]);
            if (px != py) {
                data[px] = py;
                n--;
            }
        }
        return n;
    }

    public int find(int[] data, int id) {
        while (id != data[id]) {
            data[id] = data[data[id]];
            id = data[id];
        }
        return id;
    }

}
