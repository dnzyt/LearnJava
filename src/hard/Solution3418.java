package hard;

// 3418. Maximum Amount of Money Robot Can Earn

public class Solution3418 {
    private int[][] coins;
    private int m;
    private int n;

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        this.m = coins.length;
        this.n = coins[0].length;

        return dfs(0, 0, 2);
    }

    private int dfs(int i, int j, int k) {
        if (i == m - 1 && j == n - 1) {
            if (k > 0)
                return Math.max(0, coins[i][j]);
            return coins[i][j];
        }
        if (i < 0 || i >= m || j < 0 || j >= n)
            return Integer.MIN_VALUE;
        int res = Math.max(dfs(i + 1, j, k), dfs(i, j + 1, k)) + coins[i][j];
        if (coins[i][j] < 0 && k > 0) {
            res = Math.max(res, Math.max(dfs(i + 1, j, k - 1), dfs(i, j + 1, k - 1)));
        }
        return res;
    }
}
