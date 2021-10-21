package problems;

public class NumberOfIslands {

    public int NumberOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    dfs(i, j, grid);
                }
            }
        }
        return total;

    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }

}
