package hard;

// 834. Sum of Distances in Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution834 {

    // 换根DP
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] numOfChildren = new int[n];
        Arrays.fill(numOfChildren, 1);
        int[] dist = new int[n];
        dfs(g, 0, -1, 0, numOfChildren, dist);
        reroot(g, 0, -1, numOfChildren, dist);
        return dist;
    }

    private void dfs(List<Integer>[] g, int node, int pa, int depth, int[] numOfChildren, int[] dist) {
        dist[0] += depth;
        for (int nxt : g[node]) {
            if (nxt == pa)
                continue;
            dfs(g, nxt, node, depth + 1, numOfChildren, dist);
            numOfChildren[node] += numOfChildren[nxt];
        }
    }

    private void reroot(List<Integer>[] g, int node, int pa, int[] numOfChildren, int[] dist) {
        int n = g.length;
        for (int nxt : g[node]) {
            if (nxt == pa)
                continue;
            dist[nxt] = dist[node] + n - 2 * numOfChildren[nxt]; // dist[pa] + (n - numOfChildren[node]) - numOfChildren[node]
            reroot(g, nxt, node, numOfChildren, dist);
        }
    }


}
