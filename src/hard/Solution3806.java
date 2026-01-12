package hard;

// 3806. Maximum Bitwise AND After Increment Operations

import java.util.Arrays;

public class Solution3806 {
    public int maximumAND(int[] nums, int k, int m) {
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums)
            maxNum = Math.max(maxNum, num);
        int width = 32 - Integer.numberOfLeadingZeros(maxNum + k);
        int ans = 0;
        int[] ops = new int[n];
        for (int i = width - 1; i >= 0; i--) {
            int target = ans | (1 << i);
            for (int j = 0; j < n; j++) {
                // 从左往右找到第一个target为1并且nums[j]为0的位置
                int hi = 32 - Integer.numberOfLeadingZeros(target & ~nums[j]);
                int mask = (1 << hi) - 1;
                ops[j] = (target & mask) - (nums[j] & mask);
            }
            Arrays.sort(ops);
            long sumM = 0;
            for (int j = 0; j < m; j++)
                sumM += ops[j];
            if (sumM <= k)
                ans = target;
        }
        return ans;
    }
}
