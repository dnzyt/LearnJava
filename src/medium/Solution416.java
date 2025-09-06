package medium;

// 416. Partition Equal Subset Sum


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        return dfs(n - 1, nums, target);

    }

    private boolean dfs(int i, int[] nums, int target) {
        if (i == -1) {
            return target == 0;
        }

        if (target < 0) return false;
        return dfs(i - 1, nums, target - nums[i]) || dfs(i - 1, nums, target);
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] f = new boolean[n + 1][target + 1];
        f[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                f[i][j] = j >= nums[i - 1] && f[i - 1][j - nums[i - 1]] || f[i - 1][j];
            }
        }
        return f[n][target];
    }

}
