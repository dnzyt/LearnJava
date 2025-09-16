package hard;

// 2646. Minimize the Total Price of the Trips

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2646 {
    private int[] price;
    private List<Integer>[] g;
    private int[] cnt;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.cnt = new int[n];
        g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        for (int[] t : trips) {
            int start = t[0], end = t[1];
            dfs(start, end, -1);
        }
        for (int i = 0; i < n; i++) {
            price[i] = price[i] * cnt[i];
        }
        this.price = price;

        int[] ans = dfs2(0, -1);

        return Math.min(ans[0], ans[1]);
    }

    private boolean dfs(int start, int end, int fa) {
        if (start == end) {
            cnt[start]++;
            return true;
        }
        for (int nxt : g[start]) {
            if (nxt == fa) continue;
            if (dfs(nxt, end, start)) {
                cnt[start]++;
                return true;
            }
        }
        return false;
    }

    private int[] dfs2(int x, int fa) {

        int pick = price[x] / 2, notpick = price[x];
        for (int nxt : g[x]) {
            if (nxt == fa) continue;
            int[] cost = dfs2(nxt, x);
            pick += cost[1];
            notpick += Math.min(cost[0], cost[1]);
        }
        return new int[]{pick, notpick};
    }
}
