package medium;

// 4057. Number of Intersecting Interval Pairs II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4057 {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        long ans = 0;
        List<Integer> pos = new ArrayList<>();
        for (int[] interval : intervals) {
            int idx = lowerBound(pos, interval[0] - 1);
            ans += pos.size() - idx;
            pos.add(interval[1]);
        }
        return ans;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
