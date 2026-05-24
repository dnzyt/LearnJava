package medium;

// 164. Maximum Gap

import java.util.Arrays;

public class Solution164 {
    // 桶排序 O(n)
    public int maximumGap(int[] nums) {
        int mx = -1;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }
        int n = nums.length;
        if (mx - mn <= 1)
            return mx - mn;
        // 上取整转换为下取整 ⌈a/b⌉ = ⌊(a + (b - 1)/b⌋
        int d = (mx - mn + n - 1 - 1) / (n - 1);
        int[][] buckets = new int[(mx - mn) / d + 1][2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i][0] = Integer.MAX_VALUE / 2;
            buckets[i][1] = Integer.MIN_VALUE / 2;
        }
        for (int num : nums) {
            int i = (num - mn) / d;
            buckets[i][0] = Math.min(buckets[i][0], num);
            buckets[i][1] = Math.max(buckets[i][1], num);
        }
        int ans = d; // 最大间隔不会小于平均值
        int preMax = buckets[0][1];
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE / 2)
                continue;
            ans = Math.max(buckets[i][0] - preMax, ans);
            preMax = buckets[i][1];
        }
        return ans;
    }
}
