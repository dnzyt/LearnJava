package hard;

// 3791. Number of Balanced Integers in a Range

import java.util.Arrays;

public class Solution3791 {
    private int n;
    private String highStr;
    private String lowStr;
    private long[][] memo;


    // 数位DP
    public long countBalanced(long low, long high) {
        low = Math.max(low, 11);
        if (high < low)
            return 0;
        highStr = Long.toString(high);
        lowStr = Long.toString(low);
        lowStr = "0".repeat(highStr.length() - lowStr.length()) + lowStr;
        n = highStr.length();
        memo = new long[n][300];
        for (long[] row : memo)
            Arrays.fill(row, -1L);

        return dfs(0, 0, true, true, true);
    }

    private long dfs(int i, int diff, boolean parity, boolean lowLimit, boolean highLimit) {
        if (i == n)
            return diff == 0 ? 1 : 0;

        if (!lowLimit && !highLimit && memo[i][diff + 150] != -1)
            return memo[i][diff + 150];


        int hi = highLimit ? highStr.charAt(i) - '0' : 9;
        int lo = lowLimit ? lowStr.charAt(i) - '0' : 0;
        long res = 0;

        for (int d = lo; d <= hi; d++) {
            res += dfs(i + 1, diff + (parity ? -d : d), !parity, lowLimit && d == lo, highLimit && d == hi);
        }
        if (!lowLimit && !highLimit)
            memo[i][diff + 150] = res;
        return res;
    }
}
