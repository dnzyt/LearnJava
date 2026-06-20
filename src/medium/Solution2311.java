package medium;

// 2311. Longest Binary Subsequence Less Than or Equal to K

public class Solution2311 {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int m = 32 - Integer.numberOfLeadingZeros(k);
        if (n <= m)
            return n;
        int a = Integer.parseInt(s.substring(n - m), 2);
        int ans = a <= k ? m : m - 1;
        for (int i = 0; i < n - m; i++)
            ans += '1' - s.charAt(i);
        return ans;
    }
}
