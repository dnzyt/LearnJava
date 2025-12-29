package easy;

// 697. Degree of an Array

import java.util.HashMap;
import java.util.Map;

public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        int maxFreq = 0;
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!first.containsKey(nums[i]))
                first.put(nums[i], i);
            else
                last.put(nums[i], i);
            freq.merge(nums[i], 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(nums[i]));
        }

        int ans = Integer.MAX_VALUE;
        for (int num : freq.keySet()) {
            if (freq.get(num) != maxFreq)
                continue;
            ans = Math.min(ans, last.get(num) - first.get(num) + 1);
        }
        return ans;
    }


}
