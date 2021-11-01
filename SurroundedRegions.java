// MEDIUM = https://leetcode.com/problems/surrounded-regions/

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                visited[0][i] = true;
                queue.offer(new int[]{0, i});
            }
            if (board[m-1][i] == 'O') {
                visited[m-1][i] = true;
                queue.offer(new int[]{m-1, i});
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                visited[i][n-1] = true;
                queue.offer(new int[]{i, n-1});
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir: dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (isValid(newX, newY, board) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean isValid(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O';
    }

}
