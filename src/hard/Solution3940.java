package hard;

// 3490. Count Beautiful Numbers

import java.util.HashMap;
import java.util.Map;

public class Solution3940 {
    private Map<Long, Integer> memo;

    // 数位DP
    public int beautifulNumbers(int l, int r) {
        char[] lchs = Integer.toString(l - 1).toCharArray();
        char[] rchs = Integer.toString(r).toCharArray();
        memo = new HashMap<>();
        int rcnt = dfs(0, 1, 0, true, false, rchs);
        memo.clear();
        int lcnt = dfs(0, 1, 0, true, false, lchs);
        return rcnt - lcnt;
    }

    private int dfs(int i, int mul, int sum, boolean isLimited, boolean isNumber, char[] chs) {
        if (i == chs.length) {
            return isNumber ? (mul % sum == 0 ? 1 : 0) : 0;
        }
        long mask = (long) mul << 32 | i << 16 | sum;
        if (!isLimited && isNumber && memo.containsKey(mask))
            return memo.get(mask);
        int res = 0;
        if (!isNumber)
            res = dfs(i + 1, mul, sum, false, false, chs);
        int up = isLimited ? chs[i] - '0' : 9;
        for (int d = isNumber ? 0 : 1; d <= up; d++)
            res += dfs(i + 1, mul * d, sum + d, isLimited && d == up, true, chs);
        if (!isLimited && isNumber)
            memo.put(mask, res);
        return res;
    }
}
