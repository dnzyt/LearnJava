package hard;

// 2719. Count of Integers

import java.util.Arrays;

public class Solution2719 {
    private int minSum;
    private int maxSum;
    private static final int MOD = 1000000007;
    private int[][] memo;

    // 数位DP, 单边
    public int count(String num1, String num2, int min_sum, int max_sum) {
        minSum = min_sum;
        maxSum = max_sum;
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        memo = new int[num2.length()][maxSum + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int r = dfs(0, 0, true, false, s2);
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int l = dfs(0, 0, true, false, s1);
        int s1Sum = 0;
        for (char ch : s1)
            s1Sum += ch - '0';

        return ((r - l + ((minSum <= s1Sum && s1Sum <= maxSum) ? 1 : 0)) + MOD) % MOD;
    }

    private int dfs(int i, int sum, boolean isLimited, boolean isNumber, char[] num) {
        if (i == num.length)
            return isNumber ? (minSum <= sum && sum <= maxSum ? 1 : 0) : 0;
        if (!isLimited && isNumber && memo[i][sum] != -1)
            return memo[i][sum];
        int res = 0;
        if (!isNumber)
            res = dfs(i + 1, sum, false, false, num);
        res %= MOD;
        int low = isNumber ? 0 : 1;
        int high = isLimited ? num[i] - '0' : 9;
        for (int d = low; d <= high && sum + d <= maxSum; d++) {
            res += dfs(i + 1, sum + d, isLimited && d == high, true, num);
            res %= MOD;
        }
        if (!isLimited && isNumber)
            memo[i][sum] = res;
        return res;
    }
}
