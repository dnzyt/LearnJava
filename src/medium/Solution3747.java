package medium;

// 3747. Count Distinct Integers After Removing Zeros

import java.util.Arrays;

public class Solution3747 {
    private char[] chs;
    private long[] memo;

    public long countDistinct(long n) {
        chs = Long.toString(n).toCharArray();
        memo = new long[chs.length];
        Arrays.fill(memo, -1L);
        return dfs(0, true, false);

    }

    private long dfs(int i, boolean isLimited, boolean isNumber) {
        if (i == chs.length)
            return isNumber ? 1 : 0;
        if (!isLimited && isNumber && memo[i] != -1L)
            return memo[i];
        long res = 0L;
        if (!isNumber)
            res = dfs(i + 1, false, false);
        int high = isLimited ? chs[i] - '0' : 9;
        for (int d = 1; d <= high; d++) {
            res += dfs(i + 1, isLimited && d == high, true);
        }
        if (!isLimited && isNumber)
            memo[i] = res;
        return res;
    }
}
