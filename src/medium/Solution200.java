package medium;

// 200. Number of Islands

import java.util.List;

public class Solution200 {

    private int[][] dirs = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    char[][] grid;
    int[][] visited;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    res += 1;
                    dfs(i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0 && grid[newX][newY] == '1')
                dfs(newX, newY);
        }
    }
}
