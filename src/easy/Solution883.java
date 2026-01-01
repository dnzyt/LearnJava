package easy;

// 883. Projection Area of 3D Shapes

public class Solution883 {
    public int projectionArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] x = new int[m];
        int[] y = new int[n];

        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                y[j] = Math.max(y[j], grid[i][j]);
                x[i] = Math.max(x[i], grid[i][j]);
                if (grid[i][j] > 0)
                    ans++;
            }
        }
        for (int j = 0; j < n; j++)
            ans += y[j];
        for (int i = 0; i < m; i++)
            ans += x[i];
        return ans;


    }
}
