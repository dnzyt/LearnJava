package hard;

// 1591. Strange Printer II

import java.util.*;

public class Solution1591 {
    public boolean isPrintable(int[][] targetGrid) {
        Map<Integer, int[]> r = new HashMap<>();
        int m = targetGrid.length, n = targetGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                if (!r.containsKey(color))
                    r.put(color, new int[]{m, n, -1, -1});
                int leftTopRow = Math.min(i, r.get(color)[0]);
                int leftTopCol = Math.min(j, r.get(color)[1]);
                int rightBotRow = Math.max(i, r.get(color)[2]);
                int rightBotCol = Math.max(j, r.get(color)[3]);
                r.put(color, new int[]{leftTopRow, leftTopCol, rightBotRow, rightBotCol});
            }
        }

        Map<Integer, Integer> inDeg = new HashMap<>();
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (Integer k : r.keySet()) {
            if (!inDeg.containsKey(k))
                inDeg.put(k, 0);
            if (!g.containsKey(k))
                g.put(k, new ArrayList<>());
            int[] range = r.get(k);
            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (targetGrid[i][j] != k && !visited.contains(targetGrid[i][j]) && inRange(range, i, j)) {
                        inDeg.merge(targetGrid[i][j], 1, Integer::sum);
                        g.get(k).add(targetGrid[i][j]);
                        visited.add(targetGrid[i][j]);
                    }
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (Integer k : inDeg.keySet())
            if (inDeg.get(k) == 0)
                q.offer(k);

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int nxt : g.get(curr)) {
                inDeg.merge(nxt, -1, Integer::sum);
                if (inDeg.get(nxt) == 0)
                    q.offer(nxt);
            }
        }
        return ans.size() == r.size();
    }

    private boolean inRange(int[] range, int i, int j) {
        return range[0] <= i && range[2] >= i && range[1] <= j && range[3] >= j;
    }
}
