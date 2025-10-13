package medium;

// 1829. Maximum XOR for Each Query

public class Solution1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        int n = nums.length;
        int[] ans = new int[n];
        int a = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            ans[i] = xor ^ a;
            xor ^= nums[n - 1 - i];
        }
        return ans;
    }
}
