package hard;

// 3966. Count Good Integers in a Range

import java.util.Arrays;

public class Solution3966 {
    private char[] highStr;
    private char[] lowStr;
    private long[][] memo;
    private int diffW;
    private int k;

    public long goodIntegers(long l, long r, int k) {
        highStr = String.valueOf(r).toCharArray();
        lowStr = String.valueOf(l).toCharArray();
        diffW = highStr.length - lowStr.length;
        this.k = k;
        memo = new long[highStr.length][10];
        for (long[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, 0, true, true);
    }

    private long dfs(int i, int pre, boolean lowLimit, boolean highLimit) {
        if (i == highStr.length)
            return 1;
        if (!lowLimit && !highLimit && memo[i][pre] != -1)
            return memo[i][pre];
        long ans = 0;
        boolean isNum = !lowLimit || i > diffW;
        int hi = highLimit ? highStr[i] - '0' : 9;
        int lo = lowLimit && i >= diffW ? lowStr[i - diffW] - '0' : 0;
        int start = lo;

        // 当前位不填数字
        if (lowLimit && i < diffW) { // 检查一下能不能在当前位置不填数字
            ans += dfs(i + 1, 0, true, false);
            start = 1;
        }

        for (int d = start; d <= hi; d++) {
            if (isNum) {
                if (Math.abs(d - pre) <= k)
                    ans += dfs(i + 1, d, lowLimit && d == lo, highLimit && d == hi);
            } else {
                ans += dfs(i + 1, d, lowLimit && d == lo, highLimit && d == hi);
            }

        }
        if (!lowLimit && !highLimit)
            memo[i][pre] = ans;
        return ans;
    }
}
