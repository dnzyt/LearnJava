package hard;

// 52. N-Queens II

public class Solution52 {
    private int ans;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n + 1];
        boolean[] diag2 = new boolean[2 * n + 1];

        dfs(0, n, col, diag1, diag2);

        return ans;
    }

    private void dfs(int i, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (i == n) {
            ans ++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (col[j] || diag1[i + j] || diag2[i - j + (n - 1)]) continue;
            col[j] = true;
            diag1[i + j] = true;
            diag2[i - j + (n - 1)] = true;
            dfs(i + 1, n, col, diag1, diag2);
            col[j] = false;
            diag1[i + j] = false;
            diag2[i - j + (n - 1)] = false;
        }
    }

}
