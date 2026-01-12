package medium;

// 2447. Number of Subarrays With GCD Equal to K

public class Solution2447 {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int x = gcd(nums[j], nums[i]);
                if (x == nums[j])
                    break;
                nums[j] = x;
            }
            while (left <= i && nums[left] < k)
                left++;
            while (right <= i && nums[right] <= k)
                right++;
            ans += right - left;
        }
        return ans;
    }

    private int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }
}
