package medium;

// 994. Rotting Oranges

import java.util.Deque;
import java.util.LinkedList;

public class Solution994 {


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        Deque<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] {i, j});
            }
        int steps = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            steps ++;
            while (l > 0) {
                var curr = q.poll();
                l --;
                for (int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.offer(new int[] {newX, newY});
                    }
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    return -1;
        return steps > 0 ? steps - 1 : 0;
    }

}
