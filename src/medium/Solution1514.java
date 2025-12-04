package medium;

// 1514. Path with Maximum Probability

import java.util.*;

public class Solution1514 {
    private record Edge(int b, double succ) {
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Edge>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int a = edges[i][0], b = edges[i][1];
            double succ = succProb[i];
            g[a].add(new Edge(b, succ));
            g[b].add(new Edge(a, succ));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.<Edge>comparingDouble(e -> e.succ).reversed());

        double[] dist = new double[n];
        dist[start] = 1;
        q.offer(new Edge(start, 1));
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            int currNode = curr.b;
            double prob = curr.succ;
            if (prob < dist[currNode])
                continue;
            for (Edge nxt : g[currNode]) {
                int nxtNode = nxt.b;
                double succ = nxt.succ;
                if (prob * succ > dist[nxtNode]) {
                    dist[nxtNode] = prob * succ;
                    q.offer(new Edge(nxtNode, dist[nxtNode]));
                }
            }
        }
        return dist[end];
    }
}
