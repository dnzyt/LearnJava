package medium;

// 238. Product of Array Except Self

public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++)
            res[i] = prefix[i] * suffix[i];
        return res;
    }

}
