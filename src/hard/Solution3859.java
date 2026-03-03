package hard;

import java.util.HashMap;
import java.util.Map;

// 3859. Count Subarrays With K Distinct Integers

public class Solution3859 {
    private int k;
    private int[] nums;
    private int m;

    // 恰好型滑动窗口
    public long countSubarrays(int[] nums, int k, int m) {
        this.k = k;
        this.nums = nums;
        this.m = m;
        return greaterOrEqual(k) - greaterOrEqual(k + 1);
    }

    // 求至少有distinct个不同元素的字数组中，满足条件（出现m次）的元素至少有k个的子组个数
    private long greaterOrEqual(int distinct) {
        int n = nums.length;
        long ans = 0;
        int ge = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            cnt.merge(num, 1, Integer::sum);
            if (cnt.get(num) == m)
                ge++;
            while (cnt.size() >= distinct && ge >= k) {
                cnt.merge(nums[left], -1, Integer::sum);
                if (cnt.get(nums[left]) == m - 1)
                    ge--;
                if (cnt.get(nums[left]) == 0) {
                    cnt.remove(nums[left]);
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
