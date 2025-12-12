package medium;

// 1786. Number of Restricted Paths From First to Last Node

import java.util.*;

public class Solution1786 {
    private static final int MOD = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0] - 1].add(new int[]{e[1] - 1, e[2]});
            g[e[1] - 1].add(new int[]{e[0] - 1, e[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n - 1] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, n - 1});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0];
            int currNode = curr[1];
            if (d > dist[currNode])
                continue;
            for (int[] nxt : g[currNode]) {
                int nxtNode = nxt[0];
                int w = nxt[1];
                if (d + w < dist[nxtNode]) {
                    dist[nxtNode] = d + w;
                    q.offer(new int[]{dist[nxtNode], nxtNode});
                }
            }
        }
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(g, dist, n - 1, memo);

    }


    private int dfs(List<int[]>[] g, int[] dist, int node, int[] memo) {
        if (node == 0)
            return 1;
        int ans = 0;
        for (int[] nxt : g[node]) {
            int nxtNode = nxt[0];
            if (dist[nxtNode] <= dist[node])
                continue;
            if (memo[nxtNode] != -1) {
                ans += memo[nxtNode];
            } else {
                ans += dfs(g, dist, nxtNode, memo);
            }
            ans %= MOD;
        }
        memo[node] = ans;
        return ans;
    }
}
