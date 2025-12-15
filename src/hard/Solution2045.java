package hard;

// 2045. Second Minimum Time to Reach Destination

import java.util.*;

public class Solution2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0] - 1].add(e[1] - 1);
            g[e[1] - 1].add(e[0] - 1);
        }

        int[][] dist = new int[2][n];
        Arrays.fill(dist[0], Integer.MAX_VALUE / 2);
        Arrays.fill(dist[1], Integer.MAX_VALUE / 2);
        dist[0][0] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                int[] curr = q.poll();
                int d = curr[0], currNode = curr[1];
                int nxtD = next(d, time, change);
                for (int nxt : g[currNode]) {
                    if (nxtD < dist[0][nxt]) {
                        dist[0][nxt] = nxtD;
                        q.offer(new int[]{nxtD, nxt});
                    } else if (dist[0][nxt] < nxtD && nxtD < dist[1][nxt]) {
                        dist[1][nxt] = nxtD;
                        q.offer(new int[]{nxtD, nxt});
                    }
                }
            }
        }

        return dist[1][n - 1];
    }

    private int next(int d, int time, int change) {
        int times = d / change;
        if (times % 2 == 1) {
            return (times + 1) * change + time;
        }
        return d + time;
    }
}
