package medium;

// 3650. Minimum Cost Path with Edge Reversals

import java.util.*;

public class Solution3650 {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], 2 * e[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0] = 0;
        q.offer(new int[]{0, 0});
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
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
