package hard;

// 2246. Longest Path With Different Adjacent Characters

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2246 {
    private List<Integer>[] g;
    private int ans;
    private char[] w;

    public int longestPath(int[] parent, String s) {
        w = s.toCharArray();
        int n = parent.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        dfs(0);
        return ans;
    }

    private int dfs(int i) {
        if (g[i].size() == 0) return 0;
        int maxLen = Integer.MIN_VALUE / 2;
        for (int x : g[i]) {
            int currLen = dfs(x);
            if (w[i] != w[x]) {
                ans = Math.max(ans, currLen + maxLen + 2);
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
