package easy;

// 2144. Minimum Cost of Buying Candies With Discount

import java.util.Arrays;

public class Solution2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i - 1 >= 0)
                ans += cost[i - 1];
        }
        return ans;
    }
}
