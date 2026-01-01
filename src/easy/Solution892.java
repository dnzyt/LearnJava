package easy;

// 892. Surface Area of 3D Shapes

public class Solution892 {
    private static final int[][] DIRS = {{0, -1}, {-1, 0}};

    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (0, -1), (-1, 0)
                ans += grid[i][j] * 4 + grid[i][j] == 0 ? 0 : 2;
                for (int[] dir : DIRS) {
                    int newx = i + dir[0];
                    int newy = j + dir[1];
                    if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                        continue;
                    int x = Math.min(grid[i][j], grid[newx][newy]);
                    ans -= 2 * x;
                }
            }
        }
        return ans;
    }
}
