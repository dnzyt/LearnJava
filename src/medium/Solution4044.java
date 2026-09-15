package medium;

// 4044. Count Good Cyclic Rotations

public class Solution4044 {
    public int countGoodRotations(int[] nums) {
        long sum = 0;
        for (int num : nums)
            sum += num;
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = nums[i] + presum[i];
        int ans = 0, half = n / 2;
        for (int i = 0; i < n; i++) {
            long right = sum + presum[i] - ((half + i >= n) ? sum + presum[i - half] : presum[half + i]);
            if (sum - right > right)
                ans++;
        }
        return ans;
    }
}
