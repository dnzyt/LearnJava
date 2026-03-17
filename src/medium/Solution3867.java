package medium;

// 3867. Sum of GCD of Formed Pairs

import java.util.Arrays;

public class Solution3867 {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx = nums[0];
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b != 0)
            return gcd(b, a % b);
        return a;
    }
}
