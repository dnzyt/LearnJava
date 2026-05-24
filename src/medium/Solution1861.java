package medium;

// 1861. Rotating the Box

import java.util.Arrays;

public class Solution1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        for (char[] row : ans)
            Arrays.fill(row, '.');
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (boxGrid[i][j] == '#')
                    cnt++;
                else if (boxGrid[i][j] == '*') {
                    ans[j][m - 1 - i] = '*';
                    for (int k = 1; k <= cnt; k++)
                        ans[j - k][m - 1 - i] = '#';
                    cnt = 0;
                }
            }
            if (boxGrid[i][n - 1] == '#' || boxGrid[i][n - 1] == '.') {
                for (int k = 1; k <= cnt; k++)
                    ans[n - k][m - 1 - i] = '#';
            }
        }
        return ans;
    }
}
