package hard;

// 329. Longest Increasing Path in a Matrix

import java.util.Arrays;

public class Solution329 {
    private int[][] matrix;
    private int m;
    private int n;
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int[] row : visited)
            Arrays.fill(row, -1);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != -1)
                    res = Math.max(res, visited[i][j]);
                else
                    res = Math.max(res, dfs(i, j, visited));
            }
        return res;
    }

    private int dfs(int i, int j, int[][] visited) {
        if (visited[i][j] != -1)
            return visited[i][j];
        int res = Integer.MIN_VALUE;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (matrix[i][j] < matrix[x][y])
                res = Math.max(res, dfs(x, y, visited));
        }
        return visited[i][j] = (res == Integer.MIN_VALUE ? 0 : res) + 1;
    }


}
