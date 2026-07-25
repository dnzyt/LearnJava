package medium;

// 3335. Total Characters in String After Transformations I

import java.util.Arrays;

public class Solution3335 {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        int[][] memo = new int[t + 1][26];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        long ans = 0;
        for (char x : s.toCharArray()) {
            int num = x - 'a';
            if (cnt[num] == -1)
                cnt[num] = dfs(t, num, memo);
            ans = (ans + cnt[num]) % MOD;
        }
        return (int) ans;
    }

    private int dfs(int i, int j, int[][] memo) {
        if (i == 0)
            return 1;
        if (memo[i][j] != -1)
            return memo[i][j];
        long ans = 0;
        if (j == 25) {
            ans = dfs(i - 1, 0, memo) + dfs(i - 1, 1, memo);
        } else {
            ans = ans + dfs(i - 1, j + 1, memo);
        }
        return memo[i][j] = (int) (ans % MOD);
    }
}
