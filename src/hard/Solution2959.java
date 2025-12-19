package hard;

// 2959. Number of Possible Sets of Closing Branches

import java.util.Arrays;

public class Solution2959 {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int[][] g = new int[n][n];
        for (int[] row : g)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int[] r : roads) {
            g[r[0]][r[1]] = Math.min(g[r[0]][r[1]], r[2]);
            g[r[1]][r[0]] = Math.min(g[r[1]][r[0]], r[2]);
        }
        for (int i = 0; i < n; i++)
            g[i][i] = 0;

        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {

            ans += check(copy(g), i, maxDistance);
        }
        return ans;
    }

    private int check(int[][] g, int s, int maxDistance) {
        int n = g.length;
        for (int k = 0; k < n; k++) {
            if (((s >> k) & 1) == 0)
                continue;
            for (int i = 0; i < n; i++) {
                if (((s >> i) & 1) == 0)
                    continue;
                for (int j = 0; j < n; j++) {
                    if (((s >> j) & 1) == 0)
                        continue;
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (((s >> i) & 1) == 0)
                continue;
            for (int j = 0; j < n; j++) {
                if (((s >> j) & 1) == 0)
                    continue;
                if (g[i][j] > maxDistance)
                    return 0;
            }
        }

        return 1;
    }

    private int[][] copy(int[][] g) {
        int n = g.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++)
            f[i] = Arrays.copyOfRange(g[i], 0, n);
        return f;
    }
}
