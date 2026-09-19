package medium;

// 435. Non-overlapping Intervals

import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (l >= right) {
                ans++;
                right = r;
            }
        }
        return intervals.length - ans;
    }
}
