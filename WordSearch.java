// MEDIUM - https://leetcode.com/problems/word-search/

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (word.length() == index) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (search(board, i+1, j, word, index+1, visited) ||
                search(board, i-1, j, word, index+1, visited) ||
                search(board, i, j+1, word, index+1, visited) ||
                search(board, i, j-1, word, index+1, visited)) {
            return true;
        }

        visited[i][j] = false;

        return false;
    }

}
