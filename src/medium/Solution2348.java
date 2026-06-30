package medium;

// 2348. Number of Zero-Filled Subarrays

public class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0, n = nums.length;
        long ans = 0;
        while (i < n) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < n && nums[j] == 0)
                    j++;
                ans += (long) (j - i) * (j - i + 1) / 2;
                i = j;
            } else
                i++;

        }
        return ans;
    }
}
