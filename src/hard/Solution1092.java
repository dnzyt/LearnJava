package hard;

// 1092. Shortest Common Supersequence

public class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        return makeAns(str1.length() - 1, str2.length() - 1, str1, str2);
    }

    private int shortestCommonSuper(String str1, String str2) {
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int m = s.length;
        int n = t.length;

        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            f[i + 1][0] = i + 1;
        for (int j = 0; j < n; j++)
            f[0][j + 1] = j + 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = 1 + f[i][j];
                } else {
                    f[i + 1][j + 1] = Math.min(f[i + 1][j], f[i][j + 1]) + 1;
                }
            }
        }
        return f[m][n];
    }

    private String makeAns(int i, int j, String s, String t) {
        if (i < 0) return t.substring(0, j + 1);
        if (j < 0) return s.substring(0, i + 1);
        if (s.charAt(i) == t.charAt(j))
            return makeAns(i - 1, j - 1, s, t) + s.charAt(i);
        if (shortestCommonSuper(s.substring(0, i + 1), t.substring(0, j + 1))
                == shortestCommonSuper(s.substring(0, i), t.substring(0, j + 1)) + 1)
            return makeAns(i - 1, j, s, t) + s.charAt(i);
        return makeAns(i, j - 1, s, t) + t.charAt(j);
    }
}
