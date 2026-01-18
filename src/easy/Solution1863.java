package easy;

// 1863. Sum of All Subset XOR Totals

import java.util.Map;

public class Solution1863 {
    // 如果一个集合含有n个元素，其中包含m个1和(n-m)个0，那么含有奇数个1的子集个数为2^(n-1)
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int orVal = 0;
        // 看每一位上是否含有1，如果有1，那么和为2^(n-1),不然为0
        for (int num : nums)
            orVal |= num;
        return orVal * (1 << (n - 1));
    }

    // DFS
    // 选或不选，二叉树思想，叶子结点为各个子集的xor值
    public int subsetXORSum2(int[] nums) {
        return dfs(0, nums, 0);
    }

    private int dfs(int idx, int[] nums, int currXor) {
        if (idx == nums.length)
            return currXor;
        return dfs(idx + 1, nums, currXor ^ nums[idx]);
    }

}
