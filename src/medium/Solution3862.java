package medium;

// 3862. Find the Smallest Balanced Index

public class Solution3862 {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long left = 0l, right = 1l;
        for (int i = 0; i < n; i++)
            left += nums[i];
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            left -= nums[i];
            if (left == right)
                return i;
            if (right > Long.MAX_VALUE / nums[i]) // 防止乘法溢出，用除法
                break;
            right *= nums[i];
        }
        return ans;
    }
}
