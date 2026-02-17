package hard;

// 879. Profitable Schemes

import java.util.Arrays;

public class Solution879 {
    private static final int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int[][] f = new int[n + 1][10001];
        f[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= group[i - 1]; j--) {
                for (int k = 10000; k >= profit[i - 1]; k--)
                    f[j][k] += f[j - group[i - 1]][k - profit[i - 1]];
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++)
            for (int j = minProfit; j < 10001; j++)
                res += f[i][j];
        return res;
    }

    // rolling DP
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int[][] f = new int[n + 1][minProfit + 1];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            int g = group[i];
            int p = profit[i];
            for (int j = n - 1; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    if (j + g <= n) {
                        f[j + g][Math.min(minProfit, k + p)] += f[j][k];
                        f[j + g][Math.min(minProfit, k + p)] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += f[i][minProfit];
            res %= MOD;
        }
        return res;
    }
}
