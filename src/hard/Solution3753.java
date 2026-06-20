package hard;

// 3753. Total Waviness of Numbers in Range II

import java.util.Arrays;

public class Solution3753 {
    private char[] chs1;
    private char[] chs2;
    private int diff;

    private long[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        chs1 = String.valueOf(num1).toCharArray();
        chs2 = String.valueOf(num2).toCharArray();
        int n = chs2.length;
        diff = chs2.length - chs1.length;
        memo = new long[n][n - 1][3][10];
        for (long[][][] a : memo)
            for (long[][] b : a)
                for (long[] row : b)
                    Arrays.fill(row, -1);
        return dfs(0, true, true, 0, 0, 0);
    }

    private long dfs(int i, boolean lowLimit, boolean highLimit, int wave, int cmp, int pre) {
        if (i == chs2.length)
            return wave;
        if (!lowLimit && !highLimit && memo[i][wave][cmp + 1][pre] != -1)
            return memo[i][wave][cmp + 1][pre];

        int lo = lowLimit && i >= diff ? chs1[i - diff] - '0' : 0;
        int hi = highLimit ? chs2[i] - '0' : 9;
        boolean isNum = !lowLimit || i > diff;
        long ans = 0;
        for (int d = lo; d <= hi; d++) {
            int newcmp = isNum ? Integer.compare(d, pre) : 0;
            ans += dfs(i + 1, lowLimit && d == lo, highLimit && d == hi, wave + ((newcmp * cmp < 0) ? 1 : 0), newcmp, d);
        }
        if (!lowLimit && !highLimit)
            memo[i][wave][cmp + 1][pre] = ans;
        return ans;
    }
}
