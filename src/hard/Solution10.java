package hard;

// 10. Regular Expression Matching

public class Solution10 {
    private char[] a;
    private char[] b;

    public boolean isMatch(String s, String p) {
        a = s.toCharArray();
        b = p.toCharArray();
        int m = s.length(), n = p.length();
        return dfs(m - 1, n - 1);
    }

    private boolean dfs(int i, int j) {
        if (i < 0) {
            return j < 0 || (b[j] == '*' && dfs(i, j - 2));
        }
        if (j < 0)
            return false;
        boolean ans = false;
        if (b[j] == '*') {
            char pre = b[j - 1];
            ans = dfs(i, j - 2);
            if (a[i] == pre || pre == '.')
                ans |= dfs(i - 1, j);

        } else if (b[j] == '.') {
            ans = dfs(i - 1, j - 1);
        } else {
            if (a[i] == b[j]) {
                ans = dfs(i - 1, j - 1);
            }
        }
        return ans;
    }
}
