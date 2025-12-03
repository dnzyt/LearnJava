package hard;

// 2608. Shortest Cycle in a Graph

import java.util.*;

public class Solution2608 {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(bfs(g, i), ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int bfs(List<Integer>[] g, int source) {
        int n = g.length;
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n];
        int[] last = new int[n];
        Arrays.fill(dist, -1);
        Arrays.fill(last, -1);
        q.offer(source);
        dist[source] = 0;
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nxt : g[curr]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[curr] + 1;
                    last[nxt] = curr;
                    q.offer(nxt);
                } else if (nxt != last[curr]) {
                    ans = Math.min(ans, dist[nxt] + dist[curr] + 1);
                }
            }
        }
        return ans;

    }
}
