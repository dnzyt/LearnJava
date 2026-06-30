package medium;

// 2370. Longest Ideal Subsequence

public class Solution2370 {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] f = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int[] temp = f.clone();
            for (int j = Math.max(0, c - k); j <= Math.min(25, c + k); j++) {
                temp[c] = Math.max(temp[c], f[j] + 1);
            }
            f = temp;
            ans = Math.max(ans, f[c]);
        }
        return ans;
    }
}
