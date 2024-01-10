package medium;

// 97. Interleaving String

public class Solution97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j] == 1;
        int k = i + j;
        if (k == s3.length())
            return true;
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res = dfs(s1, s2, s3, i + 1, j, memo);
        if (res)
            return res;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res = dfs(s1, s2, s3, i, j + 1, memo);
        memo[i][j] = res ? 1 : -1;
        return res;
    }


}
