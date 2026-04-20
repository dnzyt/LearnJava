package medium;

// 467. Unique Substrings in Wraparound String

public class Solution467 {

    // 以每个字母结尾，往左最多能延伸多长
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[26];
        int ans = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || chs[i] - 'a' != (chs[i - 1] - 'a' + 1) % 26) {
                len = 1;
            } else {
                len++;
            }
            dp[chs[i] - 'a'] = Math.max(dp[chs[i] - 'a'], len);
        }
        for (int num : dp)
            ans += num;
        return ans;
    }
}
