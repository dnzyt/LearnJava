package hard;

// 2267. Check if There Is a Valid Parentheses String Path

public class Solution2267 {
    private char[][] grid;
    private int m;
    private int n;
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int c) {
        if (i == m - 1 && j == n - 1)
            return c == 1;
        if (i < 0 || i >= m || j < 0 || j >= n || c < 0 || c > (m + n - 1) / 2)
            return false;
        int v = grid[i][j] == '(' ? 1 : -1;
        return dfs(i, j + 1, c + v) || dfs(i + 1, j, c + 1);
    }
}
