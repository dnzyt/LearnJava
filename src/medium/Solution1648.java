package medium;

// 1648. Sell Diminishing-Valued Colored Balls

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Solution1648 {
    private static final int MOD = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        Integer[] nums = new Integer[n + 1];
        for (int i = 0; i < n; i++)
            nums[i] = inventory[i];
        nums[n] = 0;
        Arrays.sort(nums, Comparator.reverseOrder());
        int i = 0, curr = nums[0];
        long ans = 0L;
        while (orders > 0) {
            while (Objects.equals(nums[i], curr))
                i++;
            int nxt = nums[i];
            int nn = curr - nums[i];
            long total = (long) i * nn;
            if (total <= orders) {
                orders -= (int) total;
                ans = (ans + (long) (curr + nxt + 1) * nn / 2 * i) % MOD;
            } else {
                int c = orders / i;
                int r = orders % i;
                ans = (ans + (long) (curr + (curr - c + 1)) * c / 2 * i + (long) (curr - c) * r) % MOD;
                break;
            }
            curr = nxt;
        }
        return (int) ans;
    }
}
