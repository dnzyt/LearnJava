package medium;

// 3933. Largest Local Values in a Matrix II

import java.util.*;

public class Solution3933 {
    private int[][][][] st;
    private int m;
    private int n;

    // 二维ST
    public int countLocalMaximums(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int wm = 32 - Integer.numberOfLeadingZeros(m);
        int wn = 32 - Integer.numberOfLeadingZeros(n);
        st = new int[wm][wn][m][n];
        st[0][0] = matrix; // 要是用原始matrix直接这样复制，那么前两个维度必须是wm和wn
        for (int k = 1; k < wn; k++) {
            int half = 1 << (k - 1);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j + (1 << k) - 1 < n; j++) {
                    st[0][k][i][j] = Math.max(st[0][k - 1][i][j], st[0][k - 1][i][j + half]);
                }
            }
        }
        for (int km = 1; km < wm; km++) {
            int half = 1 << (km - 1);
            for (int kn = 0; kn < wn; kn++) {
                for (int i = 0; i + (1 << km) - 1 < m; i++) {
                    for (int j = 0; j + (1 << kn) - 1 < n; j++) {
                        st[km][kn][i][j] = Math.max(st[km - 1][kn][i][j], st[km - 1][kn][i + half][j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = matrix[i][j];
                if (x == 0)
                    continue;
                if (Math.max(query(i - x, i + x, j - x + 1, j + x - 1), query(i - x + 1, i + x - 1, j - x, j + x)) <= x)
                    ans++;
            }
        }
        return ans;
    }

    private int query(int top, int bot, int left, int right) {
        top = Math.max(top, 0);
        bot = Math.min(bot, m - 1);
        left = Math.max(left, 0);
        right = Math.min(right, n - 1);

        int szv = 32 - Integer.numberOfLeadingZeros(bot - top + 1) - 1;
        int szh = 32 - Integer.numberOfLeadingZeros(right - left + 1) - 1;
        return Math.max(Math.max(st[szv][szh][top][left], st[szv][szh][bot - (1 << szv) + 1][left]),
                Math.max(st[szv][szh][top][right - (1 << szh) + 1], st[szv][szh][bot - (1 << szv) + 1][right - (1 << szh) + 1]));
    }

    // 二维前缀和
    public int countLocalMaximums2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<Integer, List<int[]>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    continue;
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], new ArrayList<>());
                }
                map.get(matrix[i][j]).add(new int[]{i, j});
            }
        int ans = 0;
        int[][] paper = new int[m][n];
        int[][] presum = new int[m + 1][n + 1];
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            int num = entry.getKey();
            List<int[]> positions = entry.getValue();
            for (int[] p : positions) {
                int x = p[0], y = p[1];
                if (count(matrix, presum, x, y) == 0)
                    ans++;
            }
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (matrix[i][j] == num)
                        paper[i][j] = 1;
            presum = calculatePresum(paper);
        }
        return ans;
    }

    private int count(int[][] matrix, int[][] presum, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        int num = matrix[x][y];
        int r1 = Math.max(x - num + 1, 0);
        int c1 = Math.max(y - num, 0);
        int r2 = Math.min(x + num - 1, m - 1);
        int c2 = Math.min(y + num, n - 1);
        int a = query(presum, r1, c1, r2, c2);
        r1 = Math.max(x - num, 0);
        c1 = Math.max(y - num + 1, 0);
        r2 = Math.min(x + num, m - 1);
        c2 = Math.min(y + num - 1, n - 1);
        int b = query(presum, r1, c1, r2, c2);
        return a + b;
    }

    private int query(int[][] presum, int r1, int c1, int r2, int c2) {
        return presum[r2 + 1][c2 + 1] - presum[r2 + 1][c1] - presum[r1][c2 + 1] + presum[r1][c1];
    }

    private int[][] calculatePresum(int[][] paper) {
        int m = paper.length, n = paper[0].length;
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                presum[i + 1][j + 1] = presum[i + 1][j] + presum[i][j + 1] - presum[i][j] + paper[i][j];
        return presum;
    }
}
