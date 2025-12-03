package medium;

// 743. Network Delay Time

import java.util.*;

public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] t : times) {
            g[t[0] - 1].add(new int[]{t[2], t[1] - 1});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;

        int ans = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, k - 1});
        int count = n;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int dx = curr[0];
            int node = curr[1];
            if (dx > dis[node])
                continue;
            count--;
            ans = dx;
            for (int[] nxt : g[node]) {
                int w = nxt[0];
                int y = nxt[1];
                if (w + dx < dis[y]) {
                    dis[y] = w + dx;
                    q.offer(new int[]{dis[y], y});
                }
            }
        }
        return count == 0 ? ans : -1;
    }
}
