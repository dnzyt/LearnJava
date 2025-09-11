package hard;

// 1771. Maximize Palindrome Length From Subsequences

public class Solution1771 {
    public int longestPalindrome(String word1, String word2) {
        String w = word1 + word2;
        int n = w.length();
        char[] s = w.toCharArray();
        int ans = 0;
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    f[i][j] = 2 + f[i + 1][j - 1];
                    if (i < word1.length() && word1.length() <= j)
                        ans = Math.max(ans, f[i][j]);
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }

            }
        }
        return ans;
    }
}
