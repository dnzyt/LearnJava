package hard;

// 778. Swim in Rising Water

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution778 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private record Node(int d, int x, int y) {
    }

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        dist[0][0] = grid[0][0];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(Node::d));
        q.offer(new Node(grid[0][0], 0, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int d = curr.d, x = curr.x, y = curr.y;
            if (d > dist[x][y])
                continue;
            for (int[] dir : DIRS) {
                int newx = x + dir[0], newy = y + dir[1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                    continue;
                if (d >= grid[newx][newy] && d < dist[newx][newy]) {
                    dist[newx][newy] = d;
                    q.offer(new Node(dist[newx][newy], newx, newy));
                } else if (d < grid[newx][newy] && grid[newx][newy] < dist[newx][newy]) {
                    dist[newx][newy] = grid[newx][newy];
                    q.offer(new Node(dist[newx][newy], newx, newy));
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
