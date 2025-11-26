package hard;

// 2392. Build a Matrix With Conditions

import java.util.*;
import java.util.stream.IntStream;

public class Solution2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = topSort(k, rowConditions);
        if (row.length == 0)
            return new int[0][0];
        int[] col = topSort(k, colConditions);
        if (col.length == 0)
            return new int[0][0];
        Map<Integer, Integer> cm = new HashMap<>();
        for (int i = 0; i < k; i++)
            cm.put(col[i], i);

        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            ans[i][cm.get(row[i])] = row[i] + 1;
        }
        return ans;
    }

    private int[] topSort(int n, int[][] conditions) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] x : conditions) {
            int a = x[0] - 1;
            int b = x[1] - 1;
            g[a].add(b);
            indegree[b]++;
        }
        int[] ans = new int[n];
        int idx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[idx++] = curr;
            for (int nxt : g[curr]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0)
                    q.offer(nxt);
            }
        }
        if (idx != n)
            return new int[]{};
        return ans;
    }
}
