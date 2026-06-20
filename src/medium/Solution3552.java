package medium;

// 3552. Grid Teleportation Traversal

import java.util.*;

public class Solution3552 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] mat = new char[m][];
        Map<Character, List<int[]>> teleports = new HashMap<>();
        for (int i = 0; i < m; i++) {
            mat[i] = matrix[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (Character.isUpperCase(mat[i][j])) {
                    teleports.computeIfAbsent(mat[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        Set<Character> used = new HashSet<>();
        int steps = 0;
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Deque<int[]> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                if (x == m - 1 && y == n - 1)
                    return steps;
                if (Character.isUpperCase(mat[x][y])) {
                    if (!used.contains(mat[x][y])) {
                        used.add(mat[x][y]);
                        for (int[] tele : teleports.get(mat[x][y])) {
                            if (tele[0] != x || tele[1] != y) {
                                visited[tele[0]][tele[1]] = true;
                                q.offerFirst(tele);
                            }
                        }
                    }
                }
                if (mat[x][y] != '#') {
                    for (int[] dir : DIRS) {
                        int newx = x + dir[0], newy = y + dir[1];
                        if (newx >= 0 && newx < m && newy >= 0 && newy < n && mat[newx][newy] != '#' && !visited[newx][newy]) {
                            temp.offer(new int[]{newx, newy});
                            visited[newx][newy] = true;
                        }
                    }
                }
            }
            q = temp;
            steps++;
        }

        return -1;
    }
}
