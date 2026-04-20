package hard;

// 3906. Count Good Integers on a Grid Path

import java.util.Arrays;

public class Solution3906 {

    private char[] high;
    private char[] low;
    private boolean[] inPath;
    private int n;

    private long[][] memo;

    // 数位DP
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        high = String.valueOf(r).toCharArray();
        n = high.length;
        String t = String.valueOf(l);
        low = ("0".repeat(n - t.length()) + t).toCharArray();

        inPath = new boolean[n];

        int idx = n - 1;
        inPath[idx] = true;
        for (int i = directions.length() - 1; i >= 0; i--) {
            if (directions.charAt(i) == 'D')
                idx -= 4;
            else
                idx -= 1;
            if (idx < 0)
                break;
            inPath[idx] = true;
        }

        memo = new long[n][10];
        for (long[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, 0, true, true);
    }

    private long dfs(int i, int pre, boolean lowLimit, boolean highLimit) {
        if (i == n)
            return 1;

        if (!lowLimit && !highLimit && memo[i][pre] != -1)
            return memo[i][pre];

        int lo = lowLimit ? low[i] - '0' : 0;
        int hi = highLimit ? high[i] - '0' : 9;

        long ans = 0;
        for (int d = lo; d <= hi; d++) {
            if (inPath[i]) {
                if (d >= pre)
                    ans += dfs(i + 1, d, lowLimit && d == lo, highLimit && d == hi);
            } else {
                ans += dfs(i + 1, pre, lowLimit && d == lo, highLimit && d == hi);
            }
        }
        if (!lowLimit && !highLimit)
            memo[i][pre] = ans;

        return ans;
    }
}
