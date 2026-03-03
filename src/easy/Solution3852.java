package easy;

// 3852. Smallest Pair With Different Frequencies

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3852 {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        int f = cnt.get(nums[0]);
        for (int i = 1; i < nums.length; i++)
            if (f != cnt.get(nums[i]))
                return new int[]{nums[0], nums[i]};
        return new int[]{-1, -1};
    }
}
