package hard;

// 3123. Find Edges in Shortest Paths

import java.util.*;

public class Solution3123 {
    private record Edge(int node, int w, int idx) {
    }

    // 判断最短路是由哪些边组成的
    public boolean[] findAnswer(int n, int[][] edges) {
        // [end, weight, index]
        List<Edge>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            g[u].add(new Edge(v, w, i));
            g[v].add(new Edge(u, w, i));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        // [node, d, 0]
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Edge(0, 0, 0));
        while (!pq.isEmpty()) {
            Edge c = pq.poll();
            int d = c.w, curr = c.node;
            if (d > dist[curr])
                continue;
            for (Edge e : g[curr]) {
                int nxtNode = e.node, weight = e.w;
                if (dist[nxtNode] > dist[curr] + weight) {
                    dist[nxtNode] = dist[curr] + weight;
                    pq.offer(new Edge(nxtNode, dist[nxtNode], 0));
                }
            }
        }
        boolean[] ans = new boolean[edges.length];
        dfs(n - 1, g, dist, new boolean[n], ans);
        return ans;
    }

    private void dfs(int node, List<Edge>[] g, int[] dist, boolean[] visited, boolean[] ans) {
        if (visited[node])
            return;
        visited[node] = true;
        for (Edge nxt : g[node]) {
            int nxtNode = nxt.node, weight = nxt.w, idx = nxt.idx;
            if (dist[node] == dist[nxtNode] + weight) {
                ans[idx] = true;
                dfs(nxtNode, g, dist, visited, ans);
            }
        }
        return;
    }

}
