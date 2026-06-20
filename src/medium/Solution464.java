package medium;

// 464. Can I Win

import java.util.Arrays;

public class Solution464 {
    private int maxChoosableInteger;
    private int[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosableInteger = maxChoosableInteger;
        if (desiredTotal == 0)
            return true;
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        memo = new int[1 << maxChoosableInteger];
        Arrays.fill(memo, -1);
        return dfs(0, desiredTotal);
    }

    private boolean dfs(int status, int total) {
        if (total <= 0)
            return false;
        if (memo[status] != -1)
            return memo[status] == 1;
        boolean ans = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((status >> i) & 1) == 0 && !dfs(status | (1 << i), total - (i + 1))) {
                ans = true;
                break;
            }
        }
        memo[status] = ans ? 1 : 0;
        return ans;
    }
}
