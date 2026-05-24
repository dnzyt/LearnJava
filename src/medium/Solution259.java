package medium;

// 259. 3Sum Smaller

import java.util.Arrays;

public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int j = 1; j < n - 1; j++) {
            int i = 0, k = n - 1;
            while (i < j && j < k) {
                if (nums[i] + nums[k] < target - nums[j]) {
                    ans += k - j;
                    i++;
                } else {
                    k--;
                }
            }
        }

        return ans;
    }
}
