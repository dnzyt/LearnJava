package hard;

// 174. Dungeon Game

import java.util.Arrays;

public class Solution174 {

    // f[i][j]表示从当前点到右下角需要的最少血量
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] f = new int[m + 1][n + 1];
        for (int[] row : f)
            Arrays.fill(row, Integer.MAX_VALUE);
        f[m][n - 1] = f[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                f[i][j] = Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j];
                f[i][j] = Math.max(f[i][j], 1);
            }
        return f[0][0];

    }


}
