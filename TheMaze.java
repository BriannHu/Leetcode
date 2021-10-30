// MEDIUM - https://leetcode.com/problems/the-maze/

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        queue.offer(start);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i=0; i<len; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == destination[0] && y == destination[1]) {
                    return true;
                }

                for (int[] dir: dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    while (isValid(newX, newY, maze)) {
                        newX += dir[0];
                        newY += dir[1];
                    }
                    newX -= dir[0];
                    newY -= dir[1];
                    if (!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int[][] maze) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1;
    }

}
