package hard;

// 639. Decode Ways II

import java.util.Arrays;

public class Solution639 {
    private long[] memo;
    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        memo = new long[n];
        Arrays.fill(memo, -1l);
        return (int) dfs(0, chs);
    }

    private long dfs(int i, char[] chs) {
        if (i == chs.length)
            return 1l;
        if (chs[i] == '0')
            return 0l;
        if (memo[i] != -1)
            return memo[i];
        long ans = 0l;
        if (chs[i] == '*') {
            ans = (ans + 9 * dfs(i + 1, chs) % MOD) % MOD;
            if (i + 1 < chs.length) {
                if (chs[i + 1] == '*')
                    ans = (ans + 15 * dfs(i + 2, chs) % MOD) % MOD;
                else {
                    ans = (ans + dfs(i + 2, chs)) % MOD;
                    if (20 + (chs[i + 1] - '0') <= 26)
                        ans = (ans + dfs(i + 2, chs)) % MOD;
                }
            }
        } else {
            ans = (ans + dfs(i + 1, chs)) % MOD;
            if (i + 1 < chs.length) {
                if (chs[i + 1] == '*') {
                    if (chs[i] == '1')
                        ans = (ans + 9 * dfs(i + 2, chs) % MOD) % MOD;
                    else if (chs[i] == '2')
                        ans = (ans + 6 * dfs(i + 2, chs) % MOD) % MOD;
                } else {
                    if ((chs[i] - '0') * 10 + (chs[i + 1] - '0') <= 26)
                        ans = (ans + dfs(i + 2, chs)) % MOD;
                }
            }
        }
        return memo[i] = ans % MOD;
    }
}
