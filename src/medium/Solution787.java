package medium;

// 787. Cheapest Flights Within K Stops

import java.util.Arrays;

public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] nxt = Arrays.copyOf(dist, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                if (dist[u] < Integer.MAX_VALUE && dist[u] + price < nxt[v])
                    nxt[v] = dist[u] + price;
            }
            dist = nxt;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
