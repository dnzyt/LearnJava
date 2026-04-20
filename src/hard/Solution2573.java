package hard;

// 2573. Find the String with LCP

public class Solution2573 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        int i = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int j = i; j < n; j++) {
                if (lcp[i][j] != 0)
                    s[j] = ch;
            }
            while (i < n && s[i] != 0)
                i++;
            if (i == n)
                break;
        }
        if (i != n)
            return "";
        for (int j = 0; j < n; j++) {
            if (s[j] == 0)
                return "";
        }

        for (i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int actual = s[i] == s[j] ? ((i == n - 1 || j == n - 1) ? 1 : lcp[i + 1][j + 1] + 1) : 0;
                if (actual != lcp[i][j])
                    return "";
            }
        }
        return new String(s);
    }
}
