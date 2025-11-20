package medium;

// 261. Graph Valid Tree

import util.UnionFind;

import java.util.ArrayList;
import java.util.List;


public class Solution261 {

    // 并查集解法
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.find(a) == uf.find((b)))
                return false;
            uf.merge(a, b);
        }
        return true;
    }

    // DFS + Parent
    public boolean validTree2(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        int[] visited = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && hasCycle(i, -1, visited, graph))
                return false;
        }
        return true;
    }

    private boolean hasCycle(int curr, int parent, int[] visited, List<List<Integer>> graph) {
        visited[curr] = 1;
        for (Integer nxt : graph.get(curr)) {
            if (nxt == parent) continue;
            if (visited[nxt] == 1) return true;
            if (hasCycle(nxt, curr, visited, graph)) return true;
        }
        return false;
    }

}
