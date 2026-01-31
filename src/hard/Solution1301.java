package hard;

// 1301. Number of Paths with Max Score

import java.util.Arrays;
import java.util.List;

public class Solution1301 {
    private char[][] b;
    private int m;
    private int n;
    private int[][][] memo;
    private static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        m = board.size();
        n = board.get(0).length();
        memo = new int[m][n][2];
        for (int[][] x : memo)
            for (int[] row : x)
                Arrays.fill(row, -1);

        b = new char[m][];
        for (int i = 0; i < m; i++)
            b[i] = board.get(i).toCharArray();

        return dfs(0, 0);
    }

    private int[] dfs(int i, int j) {
        if (b[i][j] == 'X')
            return new int[]{0, 0};
        if (b[i][j] == 'S')
            return new int[]{0, 1};
        if (memo[i][j][0] != -1)
            return memo[i][j];

        int s = -1, cnt = 0;
        int val = b[i][j] == 'E' ? 0 : b[i][j] - '0';
        if (i + 1 < m) {
            int[] t = dfs(i + 1, j);
            if (t[1] != 0 && s < t[0] + val) {
                s = t[0] + val;
                cnt = t[1];
            }
        }
        if (j + 1 < n) {
            int[] t = dfs(i, j + 1);
            if (t[1] != 0) {
                if (s < t[0] + val) {
                    s = t[0] + val;
                    cnt = t[1];
                } else if (s == t[0] + val) {
                    cnt += t[1];
                }
            }
        }
        if (i + 1 < m && j + 1 < n) {
            int[] t = dfs(i + 1, j + 1);
            if (t[1] != 0) {
                if (s < t[0] + val) {
                    s = t[0] + val;
                    cnt = t[1];
                } else if (s == t[0] + val) {
                    cnt += t[1];
                }
            }
        }
        return memo[i][j] = (s == -1 ? new int[]{0, 0} : new int[]{s, cnt % MOD});
    }

}
