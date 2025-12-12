package medium;

// 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

import java.util.Arrays;

public class Solution1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][][] f = new int[n + 1][n][n];
        for (int[][] s : f) {
            for (int[] row : s)
                Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        for (int[] e : edges) {
            f[0][e[0]][e[1]] = e[2];
            f[0][e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    f[k + 1][i][j] = Math.min(f[k][i][j], f[k][i][k] + f[k][k][j]);
        }

        int ans = -1;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (f[n][i][j] <= distanceThreshold)
                    c++;
            }
            if (c <= count) {
                count = c;
                ans = i;
            }
        }
        return ans;
    }
}
