package hard;

// 685. Redundant Connection II

import util.UnionFind;

import java.util.*;

public class Solution685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = 0;
        for (int[] e : edges)
            n = Math.max(n, Math.max(e[0], e[1]));
        int[] inDeg = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] potential = null;
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            inDeg[e[1]]++;
            if (inDeg[e[1]] == 2)
                potential = e;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0)
                q.offer(i);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            count++;
            for (int nxt : g[curr]) {
                inDeg[nxt]--;
                if (inDeg[nxt] == 0)
                    q.offer(nxt);
            }
        }
        if (count == n)
            return potential;
        if (potential != null) {
            for (int[] e : edges) {
                if (e[1] == potential[1] && !visited[e[0]])
                    return e;
            }
            return potential;
        }

        UnionFind uf = new UnionFind(n + 1);
        for (int[] e : edges) {
            if (visited[e[0]] || visited[e[1]])
                continue;
            int pa = uf.find(e[0]);
            int pb = uf.find(e[1]);
            if (pa == pb)
                return e;
            uf.merge(e[0], e[1]);
        }

        return null;
    }
}
