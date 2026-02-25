package hard;

// 2322. Minimum Score After Removals on a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2322 {

    private List<Integer>[] graph;
    private int[] timeIn;
    private int[] timeOut;
    private int clock;
    private int[] xor;
    private int[] nums;

    // 树上时间戳，快速判断一个节点是否是另一个节点的parent
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        timeIn = new int[n];
        timeOut = new int[n];
        xor = new int[n];

        dfs(0, -1);

        for (int[] e : edges) {
            int x = e[0], y = e[1];
            if (!isParent(x, y)) {
                e[0] = y;
                e[1] = x;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x1 = edges[i][0], y1 = edges[i][1];
            for (int j = i + 1; j < n - 1; j++) {
                int x2 = edges[j][0], y2 = edges[j][1];
                int x, y, z;
                if (isParent(y1, x2)) {
                    x = xor[y2];
                    y = xor[y1] ^ x;
                    z = xor[0] ^ xor[y1];
                } else if (isParent(y2, x1)) {
                    x = xor[y1];
                    y = xor[y2] ^ x;
                    z = xor[0] ^ xor[y2];
                } else {
                    x = xor[y1];
                    y = xor[y2];
                    z = xor[0] ^ x ^ y;
                }
                int mx = Math.max(x, Math.max(y, z));
                int mn = Math.min(x, Math.min(y, z));
                ans = Math.min(ans, mx - mn);
            }
        }
        return ans;
    }

    private void dfs(int x, int fa) {
        timeIn[x] = clock++;
        xor[x] = nums[x];
        for (int nxt : graph[x]) {
            if (nxt == fa)
                continue;
            dfs(nxt, x);
            xor[x] ^= xor[nxt];
        }
        timeOut[x] = clock;
    }

    private boolean isParent(int x, int y) {
        return timeIn[x] <= timeIn[y] && timeOut[y] <= timeOut[x];
    }
}
