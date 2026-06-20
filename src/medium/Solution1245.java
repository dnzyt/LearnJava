package medium;

// 1245. Tree Diameter

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1245 {

    private List<Integer>[] g;
    private int ans;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0, -1);
        return ans - 1;
    }

    private int dfs(int i, int fa) {
        int first = 0, second = 0;
        for (int nxt : g[i]) {
            if (nxt == fa)
                continue;
            int temp = dfs(nxt, i);
            if (first < temp) {
                second = first;
                first = temp;
            } else if (second < temp)
                second = temp;
        }
        ans = Math.max(ans, first + second + 1);
        return first + 1;
    }
}
