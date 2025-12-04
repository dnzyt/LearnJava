package medium;

// 3604. Minimum Time to Reach Destination in Directed Graph

import java.util.*;

public class Solution3604 {
    public int minTime(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2], e[3]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0], currNode = curr[1];
            if (d > dist[currNode])
                continue;
            for (int[] nxt : g[currNode]) {
                int nxtNode = nxt[0];
                int start = nxt[1];
                int end = nxt[2];

                if (d <= end) {
                    int cost = Math.max(d, start);
                    if (cost + 1 < dist[nxtNode]) {
                        dist[nxtNode] = cost + 1;
                        q.offer(new int[]{dist[nxtNode], nxtNode});
                    }
                }
            }
        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
