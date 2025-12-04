package medium;

// 3112. Minimum Time to Visit Disappearing Nodes

import java.util.*;

public class Solution3112 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], l = edge[2];
            g[u].add(new int[]{l, v});
            g[v].add(new int[]{l, u});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0] = 0;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0], node = curr[1];
            if (d > dist[node])
                continue;
            for (int[] nxt : g[node]) {
                int l = nxt[0], nxtNode = nxt[1];
                if (d + l >= disappear[nxtNode])
                    continue;
                if (d + l < dist[nxtNode]) {
                    dist[nxtNode] = d + l;
                    q.offer(new int[]{dist[nxtNode], nxtNode});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}
