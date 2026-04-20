package easy;

// 1886. Determine Whether Matrix Can Be Obtained By Rotation

public class Solution1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int ok = (1 << 4) - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    ok &= ~(1 << 0);
                if (mat[i][j] != target[j][n - 1 - i])
                    ok &= ~(1 << 1);
                if (mat[i][j] != target[n - 1 - i][n - 1 - j])
                    ok &= ~(1 << 2);
                if (mat[i][j] != target[n - 1 - j][i])
                    ok &= ~(1 << 3);

                if (ok == 0)
                    return false;
            }
        }
        return true;
    }
}
