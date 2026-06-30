package medium;

// 2369. Check if There is a Valid Partition For The Array

public class Solution2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        ;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            if (f[i - 1] && nums[i] == nums[i - 1])
                f[i + 1] = true;
            if (i > 1) {
                if (f[i - 2] && ((nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) || (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)))
                    f[i + 1] = true;
            }
        }
        return f[n];
    }
}
