package hard;

// 3620. Network Recovery Pathways

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3620 {
    private static final long MX = Long.MAX_VALUE / 2;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        long mxCost = -1L;
        for (int[] e : edges) {
            if (!online[e[0]] || !online[e[1]])
                continue;
            g[e[0]].add(new int[]{e[1], e[2]});
            mxCost = Math.max(mxCost, e[2]);
        }
        long[] memo = new long[n];
        long l = 0, r = mxCost;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            Arrays.fill(memo, -1L);
            if (check(0, mid, g, memo) <= k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return (int) r;
    }

    private long check(int source, long costLimit, List<int[]>[] g, long[] memo) {
        int n = g.length;
        if (source == n - 1)
            return 0L;
        if (memo[source] != -1)
            return memo[source];
        long ans = MX;
        for (int[] nxtEdge : g[source]) {
            int nxtNode = nxtEdge[0];
            long nxtCost = nxtEdge[1];
            if (nxtCost < costLimit)
                continue;
            ans = Math.min(ans, nxtCost + check(nxtNode, costLimit, g, memo));
        }
        return memo[source] = ans;
    }


}
