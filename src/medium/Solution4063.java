package medium;

// 4063. Longest Subarray Divisible by K with At Most One Negation I

import java.util.HashMap;
import java.util.Map;

public class Solution4063 {
    public int longestSubarray(int[] nums, int k) {
        int ans = calc(nums, k);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
            ans = Math.max(ans, calc(nums, k));
            nums[i] = -nums[i];
        }
        return ans;
    }

    private int calc(int[] nums, int k) {
        Map<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i] % k + k) % k;
            Integer l = pos.get(sum);
            if (l == null)
                pos.put(sum, i);
            else
                ans = Math.max(ans, i - l);
        }
        return ans;
    }
}
