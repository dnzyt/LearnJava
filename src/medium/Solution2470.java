package medium;

// 2470. Number of Subarrays With LCM Equal to K

public class Solution2470 {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int lcm = 1;
            for (int j = i; j < n; j++) {
                lcm = lcm(lcm, nums[j]);
                if (k % lcm > 0)
                    break;
                if (k == lcm)
                    ans++;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
