package medium;

// 3524. Find X Value of Array I

public class Solution3524 {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[k];
        long[] ans = new long[k];

        for (int i = 0; i < n; i++) {
            int v = nums[i] % k;
            long[] t = new long[k];
            t[v % k] = 1;
            for (int j = 0; j < k; j++)
                t[(j * v % k + k) % k] += f[j];
            for (int j = 0; j < k; j++)
                ans[j] += t[j];
            f = t;
        }

        return ans;
    }
}
