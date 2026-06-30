package hard;

// 3977. Minimum Time to Reach Target With Limited Power

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3977 {
    private record Pair(long time, int power, int node) {
    }

    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g[u].add(new int[]{v, t});
        }
        long[][] dist = new long[n][power + 1];
        for (long[] row : dist)
            Arrays.fill(row, Long.MAX_VALUE);
        dist[source][power] = 0;
        // time elapsed, power remaining, node
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.time == b.time)
                return b.power - a.power;
            return (int) (a.time - b.time);
        });
        pq.offer(new Pair(0, power, source));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long time = curr.time;
            int pr = curr.power, node = curr.node;
            if (node == target)
                return new long[]{time, pr};

            if (dist[node][pr] < time || pr < cost[node])
                continue;
            for (int[] nxt : g[node]) {
                int nxtNode = nxt[0];
                long nxtT = nxt[1];
                if (dist[nxtNode][pr - cost[node]] > time + nxtT) {
                    dist[nxtNode][pr - cost[node]] = time + nxtT;
                    pq.offer(new Pair(time + nxtT, pr - cost[node], nxtNode));
                }
            }

        }
        return new long[]{-1, -1};
    }
}
