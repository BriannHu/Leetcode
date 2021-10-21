package problems;// MEDIUM - https://leetcode.com/problems/shortest-path-to-get-food/

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {

    // direction vectors
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.add(findStart(m, n, grid));

        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size(); // important - otherwise queue changes size
            for (int k = 0; k<len; k++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                if (grid[x][y] == '#') {
                    return step;
                }

                for (int[] dir: dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (isValid(newX, newY, grid) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

            step++;
        }
        return -1;
    }

    public int[] findStart(int m, int n, char[][] grid) {
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean isValid(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 'X';
    }

}
