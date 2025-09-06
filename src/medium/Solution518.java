package medium;

// 518. Coin Change II

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n][amount + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        dfs(n - 1, amount, coins, memo);
        return memo[n - 1][amount];
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo) {
        if (i < 0) {
            return amount == 0 ? 1 : 0;
        }
        if (memo[i][amount] != -1) return memo[i][amount];
        int ans = dfs(i - 1, amount, coins, memo);
        if (coins[i] <= amount) {
            ans += dfs(i, amount - coins[i], coins, memo);
        }
        memo[i][amount] = ans;
        return ans;
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                f[i][j] = f[i - 1][j];
                if (coins[i - 1] <= j)
                    f[i][j] += f[i][j - coins[i - 1]];
            }
        }
        return f[n][amount];
    }
}
