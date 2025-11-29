package medium;

// 2359. Find Closest Node to Given Two Nodes

import java.util.Arrays;

public class Solution2359 {
    // 基环树，求到每个点的距离
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);

        int minDist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dist1[i], dist2[i]);
            if (d < minDist) {
                minDist = d;
                ans = i;
            }
        }
        return ans;
    }

    private int[] getDist(int[] edges, int node) {
        int[] dist = new int[edges.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int d = 0;
        while (node != -1 && dist[node] == Integer.MAX_VALUE) {
            dist[node] = d;
            d++;
            node = edges[node];
        }

        return dist;
    }
}
