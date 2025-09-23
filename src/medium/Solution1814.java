package medium;

// 1814. Count Nice Pairs in an Array

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1814 {
    // nums[i] + rev(nums[j]) = nums[j] + rev(nums[i])
    // nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
    private static final int MOD = 1_000_000_007;
    public int countNicePairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] - rev(nums[i]);
            int cnt = map.getOrDefault(val, 0);
            ans += cnt;
            map.put(val, cnt + 1);
            ans %= MOD;
        }
        return ans;
    }

    private int rev(int num) {
        if (num < 10) return num;
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int ans = 0;
        for (int d : digits) {
            ans *= 10;
            ans += d;
        }
        return ans;
    }


}
