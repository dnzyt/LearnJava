package util;

public class UnionFind {
    public int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py)
            parent[px] = py;
    }
}
