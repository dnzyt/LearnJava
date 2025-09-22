package medium;

// 3371. Identify the Largest Outlier in an Array

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3371 {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            sum += num;
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int outlier = nums[i];
            cnt.put(outlier, cnt.get(outlier) - 1);
            if ((sum - outlier) % 2 == 0) {
                int s = (sum - outlier) / 2;
                if (cnt.containsKey(s) && cnt.get(s) > 0)
                    return outlier;
            }
            cnt.put(outlier, cnt.get(outlier) + 1);
        }
        return nums[0];
    }
}
