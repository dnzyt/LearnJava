package medium;

// 3628. Maximum Number of Subsequences After One Inserting

public class Solution3628 {

    // 115 题的变形

    public long numOfSubsequences(String s) {
        long origin = numOfDistinct(s, "LCT");
        long ans1 = numOfDistinct(s, "CT");
        long ans2 = numOfDistinct(s, "LC");
        int l = 0, t = 0;
        for (int i = 0; i < s.length(); i++)
            t += s.charAt(i) == 'T' ? 1 : 0;
        long ans3 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                l++;
            if (s.charAt(i) == 'T')
                t--;
            ans3 = Math.max(ans3, (long) l * t);
        }
        return origin + Math.max(Math.max(ans1, ans2), ans3);
    }

    private long numOfDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n)
            return 0;
        long[][] f = new long[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            f[i][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = Math.min(i, n - 1); j >= 0; j--) {
                f[i + 1][j + 1] = f[i][j + 1];
                if (s.charAt(i) == t.charAt(j))
                    f[i + 1][j + 1] += f[i][j];
            }
        }
        return f[m][n];
    }
}
