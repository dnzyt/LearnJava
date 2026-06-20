package hard;

// 2318. Number of Distinct Roll Sequences

import java.util.Arrays;

public class Solution2318 {
    private static final int MOD = 1000000007;
    private int n;
    private int[][][] memo;

    public int distinctSequences(int n) {
        this.n = n;
        memo = new int[n][8][8];
        for (int[][] s : memo)
            for (int[] row : s)
                Arrays.fill(row, -1);
        return dfs(0, 7, 7);
    }

    private int dfs(int i, int last1, int last2) {
        if (i == n)
            return 1;
        if (memo[i][last1][last2] != -1)
            return memo[i][last1][last2];
        int ans = 0;
        for (int x = 1; x <= 6; x++) {
            if (x != last1 && x != last2 && gcd(x, last1) == 1)
                ans = (int) (((long) ans + dfs(i + 1, x, last1) % MOD) % MOD);
        }
        return memo[i][last1][last2] = ans;
    }

    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
