package medium;

// 1976. Number of Ways to Arrive at Destination

import javafx.util.Pair;

import java.util.*;

public class Solution1976 {
    private static final int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] r : roads) {
            g[r[0]].add(new int[]{r[1], r[2]});
            g[r[1]].add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair<Long, Integer>> q = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        q.offer(new Pair<>(0L, 0));

        while (!q.isEmpty()) {
            Pair<Long, Integer> curr = q.poll();
            Long d = curr.getKey();
            int currNode = curr.getValue();
            if (d > dist[currNode])
                continue;
            for (int[] nxt : g[currNode]) {
                int nxtNode = nxt[0];
                int w = nxt[1];
                if (d + w < dist[nxtNode]) {
                    dist[nxtNode] = d + w;
                    q.offer(new Pair<>(dist[nxtNode], nxtNode));
                }
            }
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return dfs(g, n - 1, memo, dist);
    }

    private int dfs(List<int[]>[] g, int node, int[] memo, long[] dist) {
        if (node == 0)
            return 1;

        int ans = 0;
        for (int[] nxt : g[node]) {
            int nxtNode = nxt[0];
            int w = nxt[1];
            if (dist[node] - w == dist[nxtNode]) {
                if (memo[nxtNode] == -1)
                    ans += dfs(g, nxtNode, memo, dist);
                else
                    ans += memo[nxtNode];
                ans %= MOD;
            }
        }
        memo[node] = ans;
        return ans;
    }

    // Dijkstra的过程中求出路径数
    public int countPaths2(int n, int[][] roads) {
        long[][] g = new long[n][n];
        for (long[] row : g)
            Arrays.fill(row, Long.MAX_VALUE / 2);

        for (int[] r : roads) {
            int x = r[0], y = r[1], w = r[2];
            g[x][y] = w;
            g[y][x] = w;
        }


        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 2);
        dist[0] = 0;
        boolean[] done = new boolean[n];
        int[] f = new int[n];
        f[0] = 1;
        for (; ; ) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x == -1 || dist[i] < dist[x]))
                    x = i;
            }
            done[x] = true;
            if (x == n - 1)
                return f[n - 1];
            for (int i = 0; i < n; i++) {
                if (dist[x] + g[x][i] < dist[i]) {
                    dist[i] = dist[x] + g[x][i];
                    f[i] = f[x];
                } else if (dist[x] + g[x][i] == dist[i])
                    f[i] = (f[i] + f[x]) % MOD;
            }
        }
    }
}
