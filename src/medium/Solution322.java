package medium;

// 322. Coin Change

import java.util.*;

public class Solution322 {

    // 完全背包
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int x : coins) {
            for (int c = x; c <= amount; c++)
                f[c] = Math.min(f[c], f[c - x] + 1);
        }
        return f[amount] == Integer.MAX_VALUE / 2 ? -1 : f[amount];
    }

}
