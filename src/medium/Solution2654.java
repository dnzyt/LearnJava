package medium;

// 2654. Minimum Number of Operations to Make All Array Elements Equal to 1

public class Solution2654 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int g = 0;
        int cnt = 0;
        for (int num : nums) {
            cnt += num == 1 ? 1 : 0;
            g = gcd(g, num);
        }
        if (g != 1)
            return -1;
        if (cnt > 0)
            return n - cnt;

        int l = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (gcd(nums[j], nums[i]) == nums[j])
                    break;
                nums[j] = gcd(nums[j], nums[i]);
                if (nums[j] == 1)
                    l = Math.min(l, i - j + 1);
            }
        }
        return n + l - 2;

    }

    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
