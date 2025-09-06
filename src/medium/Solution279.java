package medium;

// 279. Perfect Squares

import java.util.Arrays;

public class Solution279 {
    public int numSquares(int n) {
        int x = (int) Math.sqrt(n);
        int[][] memo = new int[x + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(x, n, memo);
    }

    private int dfs(int i, int cap, int[][] memo) {
        if (cap < 0) return Integer.MAX_VALUE;
        if (i == 0) {
            return cap == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (memo[i][cap] != -1) return memo[i][cap];
        int ans = dfs(i - 1, cap, memo);
        if (i * i <= cap) {
            ans = Math.min(ans, 1 + dfs(i, cap - i * i, memo));
        }
        memo[i][cap] = ans;
        return memo[i][cap];
    }


    // f[i][c] = min( f[i-1][c], f[i][c-i*i] )
    // f[i+1][c] = min( f[i][c], f[i+1][c-i*i] )
    public int numSquares2(int n) {
        int x = (int) Math.sqrt(n);
        int[][] f = new int[x + 1][n + 1];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 1; i < x + 1; i++) {
            for (int c = 0; c < n + 1; c++) {
                f[i][c] = f[i - 1][c];
                if (c >= i * i)
                    f[i][c] = Math.min(f[i - 1][c], f[i][c - i * i] + 1);

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < x + 1; i++) ans = Math.min(ans, f[i][n]);
        return ans;
    }
}
