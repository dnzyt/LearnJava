package medium;

// 1288. Remove Covered Intervals

import java.util.Arrays;

public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int right = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] > right)
                right = intervals[i][1];
            else
                ans++;
        }
        return n - ans;
    }

}
