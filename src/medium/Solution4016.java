package medium;

// 4016. Maximum Area of Two Non-Overlapping Square Submatrices

import java.util.Arrays;

public class Solution4016 {
    public int maxArea(int[][] mat) {
        int a = calc(mat);
        int b = calc(transpose(mat));
        return Math.max(a, b);
    }

    private int calc(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] f = new int[n + 1];
        int[] sufMax = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int tmp = f[j + 1];
                    f[j + 1] = Math.min(Math.min(f[j], pre), f[j + 1]) + 1;
                    pre = tmp;
                } else {
                    pre = f[j + 1];
                    f[j + 1] = 0;
                }
                sufMax[i] = Math.max(sufMax[i], f[j + 1]);
            }
            sufMax[i] = Math.max(sufMax[i], sufMax[i + 1]);
        }

        int ans = 0, preMax = 0;
        Arrays.fill(f, 0);
        for (int i = 0; i < m; i++) {
            if (sufMax[i + 1] <= ans)
                break;
            int pre = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int tmp = f[j + 1];
                    f[j + 1] = Math.min(Math.min(f[j], pre), f[j + 1]) + 1;
                    pre = tmp;
                } else {
                    pre = f[j + 1];
                    f[j + 1] = 0;
                }
                preMax = Math.max(preMax, f[j + 1]);
            }
            ans = Math.max(ans, Math.min(preMax, sufMax[i + 1]));
        }
        return ans * ans;

    }

    private int[][] transpose(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] t = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                t[i][j] = mat[j][i];
        }
        return t;
    }
}
