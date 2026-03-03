package hard;

// 44. Wildcard Matching

import java.util.Arrays;

public class Solution44 {
    private String a;
    private String b;
    private int[][] memo;

    public boolean isMatch(String s, String p) {
        a = s;
        b = p;
        int m = a.length(), n = b.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(m - 1, n - 1);
    }

    private boolean dfs(int i, int j) {
        if (i < 0)
            return b.substring(0, j + 1).equals("*".repeat(j + 1));
        if (j < 0)
            return false;
        if (memo[i][j] != -1)
            return memo[i][j] == 1;
        boolean ans = false;
        if (b.charAt(j) == '?') {
            ans = dfs(i - 1, j - 1);
        } else if (b.charAt(j) == '*') {
            ans = dfs(i - 1, j - 1) || dfs(i - 1, j) || dfs(i, j - 1);
        } else {
            if (a.charAt(i) == b.charAt(j)) {
                ans = dfs(i - 1, j - 1);
            }
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
