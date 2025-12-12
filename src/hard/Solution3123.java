package hard;

// 3123. Find Edges in Shortest Paths

import java.util.*;

public class Solution3123 {
    private record Edge(int a, int b, int w) {
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        List<Edge> es = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
            es.add(new Edge(e[0], e[1], e[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0];
            int currNode = curr[1];
            if (d > dist[currNode])
                continue;
            for (int[] nxt : g[currNode]) {
                int nxtNode = nxt[0];
                int w = nxt[1];
                if (d + w < dist[nxtNode]) {
                    dist[nxtNode] = d + w;
                    q.offer(new int[]{dist[nxtNode], nxtNode});
                }
            }
        }
        Set<Edge> s = new HashSet<>();
        dfs(g, n - 1, s, new boolean[n], dist);
        boolean[] ans = new boolean[es.size()];
        for (int i = 0; i < es.size(); i++) {
            if (s.contains(es.get(i)))
                ans[i] = true;
        }
        return ans;
    }

    private void dfs(List<int[]>[] g, int node, Set<Edge> s, boolean[] visited, int[] dist) {
        if (node == 0)
            return;
        visited[node] = true;
        for (int[] e : g[node]) {
            int nxtNode = e[0];
            int w = e[1];


            if (dist[node] - w == dist[nxtNode]) {
                s.add(new Edge(node, e[0], e[1]));
                s.add(new Edge(e[0], node, e[1]));
                if (visited[nxtNode])
                    continue;
                dfs(g, nxtNode, s, visited, dist);
            }
        }
        visited[node] = false;
    }

}
