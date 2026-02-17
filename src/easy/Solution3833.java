package easy;

// 3833. Count Dominant Indices

public class Solution3833 {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        double[] suffix = new double[n + 1];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + (double) nums[i];
            if (i <= n - 2)
                res += (nums[i] > suffix[i + 1] / (n - 1 - i) ? 1 : 0);
        }
        return res;
    }
}
