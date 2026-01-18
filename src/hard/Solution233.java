package hard;

// 233. Number of Digit One

import java.util.Arrays;

public class Solution233 {
    private char[] s;
    private int[][] memo;

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        memo = new int[s.length][s.length];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, 0, true);
    }

    private int dfs(int i, int cnt1, boolean limited) {
        if (i == s.length)
            return cnt1;
        if (!limited && memo[i][cnt1] != -1)
            return memo[i][cnt1];
        int ans = 0;
        int up = limited ? s[i] - '0' : 9;
        for (int x = 0; x <= up; x++) {
            ans += dfs(i + 1, cnt1 + (x == 1 ? 1 : 0), limited && x == up);
        }
        if (!limited)
            memo[i][cnt1] = ans;
        return ans;
    }

    public int countDigitOne2(int n) {
        s = Integer.toString(n).toCharArray();
        memo = new int[s.length][];
        return dfs2(0, true)[1];
    }

    // 返回从i往后合法的数字个数和1的总数
    private int[] dfs2(int i, boolean isLimited) {
        if (i == s.length)
            return new int[]{1, 0};

        if (!isLimited && memo[i] != null)
            return memo[i];
        int up = isLimited ? s[i] - '0' : 9;
        int cnt = 0, sum = 0;
        for (int d = 0; d <= up; d++) {
            int[] a = dfs2(i + 1, isLimited && d == up);
            cnt += a[0];
            sum += a[1];
            if (d == 1)
                sum += a[0];
        }
        if (!isLimited)
            memo[i] = new int[]{cnt, sum};
        return new int[]{cnt, sum};
    }
}
