package hard;

// 2836. Maximize Value of Function in a Ball Passing Game

import java.util.List;

public class Solution2836 {
    // 倍增
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int m = 64 - Long.numberOfLeadingZeros(k);
        int n = receiver.size();
        long[][] st = new long[n][m];
        int[][] jump = new int[n][m];
        for (int i = 0; i < n; i++) {
            int nxt = receiver.get(i);
            st[i][0] = nxt;
            jump[i][0] = nxt;
        }

        for (int p = 1; p < m; p++) {
            for (int i = 0; i < n; i++) {
                st[i][p] = st[i][p - 1] + st[jump[i][p - 1]][p - 1];
                jump[i][p] = jump[jump[i][p - 1]][p - 1];
            }
        }

        long ans = -1;
        for (int i = 0; i < n; i++) {
            long s = i;
            int x = i;
            for (int j = 0; j < m; j++) {
                if (((k >> j) & 1) > 0) {
                    s += st[x][j];
                    x = jump[x][j];
                }
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
