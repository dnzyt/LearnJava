package medium;

// 2925. Maximum Score After Applying Operations on a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2925 {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        long sub = dfs(0, -1, g, values);
        long sum = 0;
        for (int value : values)
            sum += value;
        return sum - sub;
    }

    private long dfs(int root, int fa, List<Integer>[] g, int[] values) {
        long sub = 0l;
        for (int nxt : g[root]) {
            if (nxt == fa)
                continue;
            sub += dfs(nxt, root, g, values);
        }
        if (sub == 0)
            return values[root];
        return Math.min(values[root], sub);
    }
}
