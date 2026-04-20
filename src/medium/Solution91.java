package medium;

// 91. Decode Ways

import java.util.Arrays;

public class Solution91 {
    private int[] memo;

    public int numDecodings(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0, chs);
    }

    private int dfs(int i, char[] chs) {
        if (i == chs.length)
            return 1;
        if (memo[i] != -1)
            return memo[i];
        if (chs[i] == '0')
            return 0;
        int ans = dfs(i + 1, chs);
        if (i + 1 < chs.length && (chs[i] - '0') * 10 + (chs[i + 1] - '0') <= 26)
            ans += dfs(i + 2, chs);
        return memo[i] = ans;
    }

    public int numDecodings2(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (chs[i] == '0')
                continue;
            dp[i] = dp[i + 1];
            if (i + 1 < chs.length && (chs[i] - '0') * 10 + (chs[i + 1] - '0') <= 26)
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }
}
