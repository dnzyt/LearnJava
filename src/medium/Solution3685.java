package medium;

// 3685. Subsequence Sum After Capping Elements

import java.util.Arrays;

public class Solution3685 {
    // 渐进式0-1背包
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] f = new boolean[k + 1];
        f[0] = true;
        boolean[] ans = new boolean[n];

        int i = 0;
        for (int x = 1; x <= n; x++) {
            while (i < n && nums[i] == x) {
                for (int j = k; j >= x; j--)
                    f[j] = f[j] | f[j - x];
                i++;
            }
            for (int j = 0; j <= Math.min(n - i, k / x); j++)
                if (f[k - j * x]) {
                    ans[x - 1] = true;
                    break;
                }
        }
        return ans;
    }
}
