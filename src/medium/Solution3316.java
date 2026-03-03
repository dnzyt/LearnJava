package medium;

// 3316. Find Maximum Removals From Source String

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3316 {
    private static final int MX = Integer.MAX_VALUE / 2;
    private char[] s;
    private char[] p;
    private Set<Integer> st;
    private int[][] memo;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        s = source.toCharArray();
        p = pattern.toCharArray();
        int m = s.length, n = p.length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        st = new HashSet<>();
        for (int x : targetIndices)
            st.add(x);
        return targetIndices.length - dfs(m - 1, n - 1);
    }

    private int dfs(int i, int j) {
        if (i < j)
            return MX;
        if (j < 0)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (s[i] == p[j]) {
            if (st.contains(i)) {
                return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i - 1, j - 1) + 1);
            } else {
                return memo[i][j] = dfs(i - 1, j - 1);
            }
        } else {
            return memo[i][j] = dfs(i - 1, j);
        }
    }
}
