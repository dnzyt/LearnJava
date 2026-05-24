package hard;

// 3928. Minimum Cost to Buy Apples II

import java.util.*;

public class Solution3928 {

    public int[] minCost(int n, int[] prices, int[][] roads) {
        List<int[]>[] g1 = new List[n];
        List<int[]>[] g2 = new List[n];
        Arrays.setAll(g1, i -> new ArrayList<>());
        Arrays.setAll(g2, i -> new ArrayList<>());
        int maxPrice = Arrays.stream(prices).max().getAsInt();
        for (int[] road : roads) {
            int u = road[0], v = road[1], cost = road[2], tax = road[3];
            if (cost < maxPrice) {
                g1[u].add(new int[]{v, cost});
                g1[v].add(new int[]{u, cost});
            }
            if (cost <= (maxPrice - 1) / tax) { // 处理溢出，用<=， 非常巧妙
                g2[u].add(new int[]{v, cost * tax});
                g2[v].add(new int[]{u, cost * tax});
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int[] a = dijkstra(i, g1, prices[i]);
            int[] b = dijkstra(i, g2, prices[i]);
            for (int j = 0; j < n; j++)
                if (a[j] + b[j] < ans[i] - prices[j])
                    ans[i] = prices[j] + a[j] + b[j];
        }
        return ans;
    }

    private int[] dijkstra(int source, List<int[]>[] g, int price) {
        int n = g.length;
        int[] dist = new int[n];
        Arrays.fill(dist, price);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - a[1]);
        dist[source] = 0;
        pq.offer(new int[]{0, source});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], currNode = curr[1];
            if (dist[currNode] < d)
                continue;
            for (int[] nxt : g[currNode]) {
                int nextNode = nxt[0], cost = nxt[1];
                if (dist[nextNode] > d + cost) {
                    dist[nextNode] = d + cost;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist;
    }

}
