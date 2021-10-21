// MEDIUM - https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int num_fresh = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    num_fresh++;
                }
            }
        }

        if (num_fresh == 0) return 0;

        while (!queue.isEmpty()) {
            minutes++;
            int len = queue.size();
            for (int i=0; i<len; i++) {
                int[] current = queue.poll();

                for (int[] dir: dirs) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];

                    if (isValid(newX, newY, grid)) {
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        num_fresh--;
                    }
                }
            }


        }

        return num_fresh == 0 ? minutes-1 : -1;
    }

    public boolean isValid(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
    }

}
