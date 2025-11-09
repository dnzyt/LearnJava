package medium;

// 684. Redundant Connection

import util.UnionFind;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(1001);
        for (int[] e : edges) {
            int x = uf.find(e[0]);
            int y = uf.find(e[1]);
            if (x == y)
                return e;
            uf.merge(x, y);
        }
        return null;
    }
}
