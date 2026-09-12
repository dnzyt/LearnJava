package medium;

// 4035. Maximum Valid Split Positions I

public class Solution4035 {
    public int maxValidSplits(int[] nums) {
        int ans = countValid(nums, -1);
        int g = 0;
        for (int i = 0; i < nums.length; i++) {
            if (g > 0 && nums[i] % g == 0)
                continue;
            g = gcd(g, nums[i]);
            ans = Math.max(ans, countValid(nums, i));
        }
        return ans;
    }


    private int countValid(int[] nums, int skip) {
        int n = nums.length;
        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i == skip) {
                suf[i] = suf[i + 1];
            } else {
                suf[i] = gcd(suf[i + 1], nums[i]);
            }
        }
        int pre = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i != skip) {
                pre = gcd(pre, nums[i]);
                if (pre == suf[i + 1])
                    cnt++;
            }
        }
        return cnt;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
