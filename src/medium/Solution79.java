package medium;

// 79. Word Search

public class Solution79 {
    private char[][] board;
    private String word;
    private int[][] visited;
    private int[][] dirs = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 1;
                if (dfs(0, i, j))
                    return true;
                visited[i][j] = 0;
            }
        }
        return false;
    }

    private boolean dfs(int start, int x, int y) {
        if (start == word.length() - 1 && word.charAt(start) == board[x][y])
            return true;

        if (board[x][y] != word.charAt(start))
            return false;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                visited[newX][newY] = 1;
                if (dfs(start + 1, newX, newY))
                    return true;
                visited[newX][newY] = 0;
            }
        }

        return false;
    }
}
