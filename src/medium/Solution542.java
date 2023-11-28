package medium;

// 542. 01 Matrix

import javafx.util.Pair;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Deque<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.offer(new Pair<>(i, j));
                    visited.add(new Pair<>(i, j));
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int l = q.size();
            while (l > 0) {
                var curr = q.poll();
                l --;
                int x = curr.getKey(), y = curr.getValue();
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited.contains(new Pair<>(newX, newY))) {
                        res[newX][newY] = 1 + res[x][y];
                        visited.add(new Pair<>(newX, newY));
                        q.offer(new Pair<>(newX, newY));
                    }
                }
            }
        }
        return res;
    }


}
