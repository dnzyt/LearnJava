package hard;

// 920. Number of Music Playlists

import java.util.Arrays;

public class Solution920 {

    private int[][] memo;
    private static final int MOD = 1000000007;
    
    public int numMusicPlaylists(int n, int goal, int k) {
        memo = new int[goal + 1][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(goal, n, k);
    }

    private int dfs(int i, int j, int k) {
        if (i == 0)
            return 1;
        if (memo[i][j] != -1)
            return memo[i][j];
        long ans = 0l;
        if (j > 0)
            ans = (long) j * dfs(i - 1, j - 1, k) % MOD;
        if (i > j && j > k)
            ans = (ans + (long) (j - k) * dfs(i - 1, j, k)) % MOD;
        return memo[i][j] = (int) ans % MOD;
    }
}
