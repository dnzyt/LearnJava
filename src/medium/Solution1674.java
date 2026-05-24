package medium;

// 1674. Minimum Moves to Make Array Complementary

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        // 在[2, limit * 2]区间枚举所有可能的最终值
        // 有两种情况需要两个数都变换
        // 1. 把数对中的最大值拉低到1再加上另一个数，如果和还是大于当前枚举的最终值，那么两个数都得变
        // 2. 把数对中的最小值往上抬到limit再加上另个数，如果和还是小于当前枚举的最终值，那么两个数都得变
        // 剩下的情况就是不需要变或者只需要变一个数就能达到最终值
        int[] higher = new int[n / 2];
        int[] lower = new int[n / 2];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            higher[i] = 1 + a;
            lower[i] = limit + b;
            cnt.merge(a + b, 1, Integer::sum);
        }
        Arrays.sort(higher);
        Arrays.sort(lower);
        int ans = Integer.MAX_VALUE;
        for (int t = 2; t <= limit * 2; t++) {
            int numOfPairs = n / 2;
            int moves = 0;
            int idx = lowerBound(higher, t + 1);
            moves += (n / 2 - idx) * 2;
            numOfPairs -= (n / 2 - idx);
            idx = lowerBound(lower, t);
            moves += idx * 2;
            numOfPairs -= idx;
            numOfPairs -= cnt.getOrDefault(t, 0);
            moves += numOfPairs;
            ans = Math.min(ans, moves);
        }
        return ans;
    }

    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
}
