package easy;

// 1995. Count Special Quadruplets

import java.util.HashMap;
import java.util.Map;


public class Solution1995 {
    private int[] nums;
    public int countQuadruplets(int[] nums) {
        this.nums = nums;
        int ans = 0;
        int n = nums.length;
        for (int i = 3; i < n; i++) {
            for (int j = i - 1; j >= 2; j--) {
                ans += f(0, j - 1, nums[i] - nums[j]);
            }
        }

        return ans;
    }

    private int f(int start, int end, int target) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            ans += map.getOrDefault(target - nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
    }
}
