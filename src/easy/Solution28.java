package easy;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        int[] suffix = getSuffix(p);

        int[] dp = new int[s.length];
        if (s.length == 0)
            return -1;
        if (p.length == 0)
            return 0;
        dp[0] = (s[0] == p[0] ? 1 : 0);
        if (p.length == 1 && dp[0] == 1)
            return 0;

        for (int i = 1; i < s.length; i++) {
            int j = dp[i-1];
            while (j > 0 && s[i] != p[j])
                j = suffix[j-1];
            dp[i] = j + (s[i] == p[j] ? 1 : 0);
            if (dp[i] == p.length)
                return i - dp[i] + 1;
        }
        return -1;

    }

    public int[] getSuffix(char[] s) {
        int n = s.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            int j = dp[i-1];
            while (j > 0 && s[i] != s[j])
                j = dp[j-1];
            dp[i] = j + (s[i] == s[j] ? 1 : 0);
        }
        return dp;
    }
}
