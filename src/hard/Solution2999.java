package hard;

// 2999. Count the Number of Powerful Integers

import java.util.Arrays;

public class Solution2999 {
    private char[] suffix;
    private int limit;
    private long[] memo;

    // 数位DP, 单边版本
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        suffix = s.toCharArray();
        this.limit = limit;
        start--;
        char[] rchs = Long.toString(finish).toCharArray();
        char[] lchs = Long.toString(start).toCharArray();
        memo = new long[rchs.length];
        Arrays.fill(memo, -1L);
        long r = dfs(0, true, false, rchs);
        memo = new long[lchs.length];
        Arrays.fill(memo, -1L);
        long l = dfs(0, true, false, lchs);
        return r - l;
    }

    private long dfs(int i, boolean isLimited, boolean isNumber, char[] chs) {
        if (i == chs.length)
            return isNumber ? 1 : 0;
        if (!isLimited && isNumber && memo[i] != -1)
            return memo[i];
        long res = 0;
        int diff = chs.length - suffix.length;
        if (diff < 0)
            return 0;
        if (!isNumber && i < diff)
            res = dfs(i + 1, false, false, chs);
        int low = isNumber ? 0 : 1;
        int high = isLimited ? chs[i] - '0' : 9;
        if (i < diff) {
            for (int d = low; d <= Math.min(high, limit); d++)
                res += dfs(i + 1, isLimited && d == high, true, chs);
        } else {
            int curr = suffix[i - diff] - '0';
            if (curr <= Math.min(high, limit))
                res += dfs(i + 1, isLimited && curr == high, true, chs);
        }
        if (!isLimited && isNumber)
            memo[i] = res;
        return res;
    }
}
