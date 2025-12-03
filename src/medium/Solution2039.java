package medium;

// 2039. The Time When the Network Becomes Idle

import java.util.*;

public class Solution2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        dist[0] = 0;

        int count = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            count++;
            while (l-- > 0) {
                int curr = q.poll();
                for (int nxt : g[curr]) {
                    if (dist[nxt] == Integer.MAX_VALUE) {
                        dist[nxt] = count;
                        q.offer(nxt);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cost = 4 * dist[i] - (2 * dist[i] - 1) % patience[i];
            ans = Math.max(ans, cost);
        }

        return ans;
    }
}
