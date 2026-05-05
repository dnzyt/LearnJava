package easy;

// 3912. Valid Elements in an Array

import java.util.ArrayList;
import java.util.List;

public class Solution3912 {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        boolean[] rightValid = new boolean[n];
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > mx)
                rightValid[i] = true;
            mx = Math.max(mx, nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        mx = 0;
        for (int i = 0; i < n; i++) {
            if (rightValid[i] || nums[i] > mx)
                ans.add(nums[i]);
            mx = Math.max(mx, nums[i]);
        }

        return ans;
    }
}
