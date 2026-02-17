package lcp;

import java.util.Arrays;

public class Solution74 {
    // 离散化 + 二维差分
    public int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        long[] xs = new long[n * 2];
        long[] ys = new long[n * 2];
        int k = 0;
        for (int[] f : forceField) {
            int x = f[0], y = f[1], r = f[2];
            xs[k] = ((long) x * 2 - r);
            ys[k++] = ((long) y * 2 - r);
            xs[k] = ((long) x * 2 + r);
            ys[k++] = ((long) y * 2 + r);
        }

        xs = unique(xs);
        ys = unique(ys);

        int[][] diff = new int[xs.length + 2][ys.length + 2];

        for (int[] f : forceField) {
            int x = f[0], y = f[1], r = f[2];
            int a = Arrays.binarySearch(xs, (long) x * 2 - r) + 1;
            int b = Arrays.binarySearch(ys, (long) y * 2 - r) + 1;
            int c = Arrays.binarySearch(xs, (long) x * 2 + r) + 1;
            int d = Arrays.binarySearch(ys, (long) y * 2 + r) + 1;
            update(diff, a, b, c, d, 1);
        }
        int ans = 0;
        for (int i = 1; i <= xs.length; i++)
            for (int j = 1; j <= ys.length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);
            }
        return ans;
    }

    private void update(int[][] diff, int a, int b, int c, int d, int val) {
        diff[a][b] += val;
        diff[a][d + 1] -= val;
        diff[c + 1][b] -= val;
        diff[c + 1][d + 1] += val;
    }

    private long[] unique(long[] a) {
        Arrays.sort(a);
        int k = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[k] != a[i])
                a[++k] = a[i];
        }
        return Arrays.copyOf(a, k + 1);
    }
}
