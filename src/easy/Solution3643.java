package easy;

// 3643. Flip Square Submatrix Vertically

public class Solution3643 {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = x; i - x < k / 2; i++) {
            for (int j = y; j < y + k; j++) {
                int tmp = grid[i][j];
                grid[i][j] = grid[x + k - 1 - (i - x)][j];
                grid[x + k - 1 - (i - x)][j] = tmp;
            }
        }
        return grid;
    }
}
