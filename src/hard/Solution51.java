package hard;

// 51. N-Queens

import java.util.ArrayList;
import java.util.List;

public class Solution51 {

    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] col = new int[n];
        boolean[] onPath = new boolean[n];
        boolean[] diag1 = new boolean[2*n - 1];
        boolean[] diag2 = new boolean[2*n - 1];
        dfs(0, n, col, onPath, diag1, diag2);
        return ans;
    }

    public void dfs(int i, int n, int[] col, boolean[] onPath, boolean[] diag1, boolean[] diag2) {
        if (i == n) {
            List<String> t = new ArrayList<>();
            for (int c : col) {
                t.add(".".repeat(c) + "Q" + ".".repeat(n - 1 - c));
            }
            ans.add(t);
        }
        for (int j = 0; j < n; j++) {
            if (onPath[j] || diag1[i + j] || diag2[i - j + (n - 1)]) continue;
            onPath[j] = true;
            diag1[i + j] = true;
            diag2[i - j + (n - 1)] = true;
            col[i] = j;
            dfs(i + 1, n, col, onPath, diag1, diag2);
            onPath[j] = false;
            diag1[i + j] = false;
            diag2[i - j + (n - 1)] = false;
        }
    }

}
