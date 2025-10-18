package medium;

// 1895. Largest Magic Square

public class Solution1895 {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowPresum = new int[m][n + 1];
        int[][] colPresum = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            int[] row = rowPresum[i];
            for (int j = 0; j < n; j++) {
                row[j + 1] = row[j] + grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            int[] col = colPresum[j];
            for (int i = 0; i < m; i++) {
                col[i + 1] = col[i] + grid[i][j];
            }
        }

        for (int l = Math.min(m, n); l > 1; l--) {
            for (int i = 0; i <= m - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    int s = rowPresum[i][j + l] - rowPresum[i][j];
                    boolean check = true;
                    for (int x = i; x < i + l; x++) {
                        if (rowPresum[x][j + l] - rowPresum[x][j] != s) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) continue;
                    for (int y = j; y < j + l; y++) {
                        if (colPresum[y][i + l] - colPresum[y][i] != s) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) continue;
                    int d1 = 0, d2 = 0;
                    for (int z = 0; z < l; z++) {
                        d1 += grid[i + z][j + z];
                        d2 += grid[i + z][j + l - 1 - z];
                    }
                    if (d1 == s && d2 == s)
                        return l;
                }
            }
        }

        return 1;
    }
}
