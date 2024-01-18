package hard;

// 1368. Minimum Cost to Make at Least One Valid Path in a Grid

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution1368 {
    // 01-BFS,不是普通BFS
    public int minCost(int[][] grid) {
        int[][] dirs = { {}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                distance[i][j] = Integer.MAX_VALUE;
        distance[0][0] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == m - 1 && y == n - 1)
                return distance[x][y];
            for (int i = 1; i <= 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                int weight = i == grid[x][y] ? 0 : 1;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (distance[x][y] + weight < distance[nx][ny]) {
                        distance[nx][ny] = distance[x][y] + weight;
                        if (weight == 0)
                            queue.offerFirst(new int[] {nx, ny});
                        else
                            queue.offer(new int[] {nx, ny});
                    }
                }

            }
        }
        return -1;
    }
}
