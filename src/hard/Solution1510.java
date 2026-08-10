package hard;

// 1510. Stone Game IV

import java.util.Arrays;

public class Solution1510 {
    public boolean winnerSquareGame(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private boolean dfs(int i, int[] memo) {
        if (i == 0)
            return false;
        if (memo[i] != -1)
            return memo[i] == 1;

        for (int x = 1; x * x <= i; x++) {
            if (!dfs(i - x * x, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}
