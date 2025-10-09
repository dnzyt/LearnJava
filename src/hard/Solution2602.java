package hard;

// 2602. Minimum Operations to Make All Array Elements Equal

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + nums[i];

        List<Long> ans = new ArrayList<>();
        for (int target : queries) {
            int lb = lowerBound(nums, target);
            long left = (long) target * (lb + 1) - presum[lb + 1];
            long right = presum[n] - presum[lb + 1] - (long) target * (n - 1 - lb);
            ans.add(left + right);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}
