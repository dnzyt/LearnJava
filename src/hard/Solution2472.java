package hard;

// 2472. Maximum Number of Non-overlapping Palindrome Substrings

public class Solution2472 {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[n + 1];
        for (int i = k; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (isPal(chs, i - k, i - 1))
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            if (i > k && isPal(chs, i - k - 1, i - 1))
                dp[i] = Math.max(dp[i], dp[i - k - 1] + 1);
        }
        return dp[n];
    }

    private boolean isPal(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }
}
