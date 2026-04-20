package hard;

// 3887. Incremental Even-Weighted Cycle Queries

public class Solution3887 {
    private int[] parent;
    private int[] dist;

    public int numberOfEdgesAdded(int n, int[][] edges) {
        parent = new int[n];
        dist = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int ans = 0;
        for (int[] e : edges) {
            if (merge(e[0], e[1], e[2]))
                ans++;
        }
        return ans;
    }

    private int find(int x) {
        int tmp = parent[x];
        int d = dist[x];
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
            dist[x] = d ^ dist[tmp];
        }
        return parent[x];
    }

    private boolean merge(int x, int y, int val) {
        int pa = find(x);
        int py = find(y);
        if (pa == py) {
            return (dist[x] ^ dist[y]) == val;
        }
        parent[pa] = py;
        dist[pa] = dist[y] ^ dist[x] ^ val;
        return true;
    }
}
