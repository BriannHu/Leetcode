// HARD - https://leetcode.com/problems/unique-paths-iii/

public class UniquePaths3 {

    int result = 0, empty = 1;
    int startX, startY;

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        dfs(startX, startY, grid);
        return result;
    }

    public void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0) {
            return;
        }
        if (grid[i][j] == 2) {
            if (empty == 0) {
                result++;
            }
            return;
        }
        grid[i][j] = -2;
        empty--;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        empty++;
        grid[i][j] = 0;
    }

}
