package medium;

// 1914. Cyclically Rotating a Grid

public class Solution1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for (int c = 0; c < Math.min(m, n) / 2; c++) {
            int kk = k % (2 * ((m - 2 * c) + (n - 2 * c)) - 4);
            while (kk-- > 0)
                rotate(c, c, grid);
        }
        return grid;
    }

    //  每次rotate 1步
    private void rotate(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int a = grid[x][y], b = grid[m - 1 - x][y], c = grid[m - 1 - x][n - 1 - y];
        for (int j = y; j < n - 1 - y; j++)
            grid[x][j] = grid[x][j + 1];
        for (int i = m - 1 - x; i > x; i--) {
            if (i == x + 1)
                grid[i][y] = a;
            else
                grid[i][y] = grid[i - 1][y];
        }
        for (int j = n - 1 - y; j > y; j--) {
            if (j == y + 1)
                grid[m - 1 - x][j] = b;
            else
                grid[m - 1 - x][j] = grid[m - 1 - x][j - 1];
        }
        for (int i = x; i < m - 1 - x; i++) {
            if (i == m - 1 - x - 1)
                grid[i][n - 1 - y] = c;
            else
                grid[i][n - 1 - y] = grid[i + 1][n - 1 - y];
        }
    }
}
