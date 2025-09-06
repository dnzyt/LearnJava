package hard;

// 300. Longest Increasing Subsequence

import java.util.ArrayList;
import java.util.List;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int num : nums) {
            int idx = lowerBound(g, num);
            if (idx == g.size())
                g.add(num);
            else
                g.set(idx, num);
        }
        return g.size();
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
