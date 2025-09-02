package medium;

// 213. House Robber II

public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob2(nums, 2, n - 1), rob2(nums, 1, n));
    }

    private int dfs(int i, int[] nums, boolean f) {
        if (i < 0) return 0;
        if (i == 0) {
            if (f) return nums[0];
            else return 0;
        }
        return Math.max(nums[i] + dfs(i - 2, nums, f), dfs(i - 1, nums, f));
    }

    // 198. 打家劫舍
    // 可以计算任意区间
    // 左闭右开
    private int rob2(int[] nums, int start, int end) {
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i < end; i ++) {
            int newF = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
