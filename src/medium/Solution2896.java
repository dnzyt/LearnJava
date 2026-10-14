package medium;

// 2896. Apply Operations to Make Two Strings Equal

import java.util.Arrays;

public class Solution2896 {
    public int minOperations(String s1, String s2, int x) {
        int c1 = 0, c2 = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == '1')
                c1++;
            if (s2.charAt(i) == '1')
                c2++;
        }
        if (c1 % 2 != c2 % 2)
            return -1;

        int[][][] memo = new int[n][n][2];
        for (int[][] s : memo)
            for (int[] row : s)
                Arrays.fill(row, -1);

        return dfs(n - 1, 0, 0, s1.toCharArray(), s2.toCharArray(), x, memo);
    }

    private int dfs(int i, int free, int prev, char[] s1, char[] s2, int x, int[][][] memo) {
        if (i < 0) {
            return free > 0 || prev > 0 ? Integer.MAX_VALUE / 2 : 0;
        }

        if (memo[i][free][prev] != -1)
            return memo[i][free][prev];

        if (s1[i] == s2[i] && prev == 0 || s1[i] != s2[i] && prev == 1)
            return memo[i][free][prev] = dfs(i - 1, free, 0, s1, s2, x, memo);

        int res = Math.min(dfs(i - 1, free + 1, 0, s1, s2, x, memo) + x, dfs(i - 1, free, 1, s1, s2, x, memo) + 1);
        if (free > 0)
            res = Math.min(res, dfs(i - 1, free - 1, 0, s1, s2, x, memo));
        return memo[i][free][prev] = res;
    }
}
