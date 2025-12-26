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
}
