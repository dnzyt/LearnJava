package medium;

// 474. Ones and Zeroes

public class Solution474 {
    // 01背包问题
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[] mCnt = new int[l];
        int[] nCnt = new int[l];
        for (int i = 0; i < l; i++) {
            char[] s = strs[i].toCharArray();
            for (char ch : s) {
                if (ch == '0')
                    mCnt[i]++;
                else
                    nCnt[i]++;
            }
        }
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= l; i++)
            for (int j = m; j - mCnt[i - 1] >= 0; j--)
                for (int k = n; k - nCnt[i - 1] >= 0; k--)
                    f[j][k] = Math.max(f[j][k], f[j - mCnt[i - 1]][k - nCnt[i - 1]] + 1);

        return f[m][n];
    }

}
