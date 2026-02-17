package hard;

// 3287. Find the Maximum Sequence Value of Array

import java.util.Arrays;

public class Solution3287 {
    // 刷表法DP
    public int maxValue(int[] nums, int k) {
        int n = nums.length;
        int mx = Arrays.stream(nums).reduce(0, (a, b) -> a | b) + 1;

        boolean[][] suffix = new boolean[n][];
        boolean[][] f = new boolean[k + 1][mx + 1];
        f[0][0] = true;
        // f[i][j][x]表示从i以及之后的元素中选j个，能否恰好OR值为x
        for (int i = n - 1; i >= k; i--) {
            for (int j = Math.min(k - 1, n - 1 - i); j >= 0; j--) {
                for (int x = 0; x < mx; x++) {
                    if (f[j][x])
                        f[j + 1][x | nums[i]] = true;
                }
            }
            // 只对选k个元素的情况感兴趣
            suffix[i] = f[k].clone();
        }

        boolean[][] prefix = new boolean[n][];
        f = new boolean[k + 1][128];
        f[0][0] = true;
        // f[i][j][x] 表示前i个元素中选j个，能否OR值恰好为x
        for (int i = 0; i < n - k; i++) {
            for (int j = Math.min(k - 1, i); j >= 0; j--) {
                for (int x = 0; x < mx; x++)
                    if (f[j][x])
                        f[j + 1][x | nums[i]] = true;
            }
            prefix[i] = f[k].clone();
        }
        int ans = 0;
        for (int i = k - 1; i < n - k; i++) {
            for (int j = 0; j < mx; j++)
                if (prefix[i][j])
                    for (int x = 0; x < mx; x++)
                        if (suffix[i + 1][x])
                            ans = Math.max(ans, j ^ x);
        }
        return ans;
    }
}
