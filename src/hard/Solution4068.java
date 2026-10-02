package hard;

// 4068. Maximize Meeting Earnings with Idle Gaps

import java.util.Arrays;

public class Solution4068 {
    public long maxEarnings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        int n = meetings.length;
        int end0 = meetings[0][1];
        long ans = 0L;
        long[] premax = new long[n + 1];
        premax[0] = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int start = meetings[i][0], end = meetings[i][1], rev = meetings[i][2];
            long f = rev;
            if (start >= end0) {
                int j = search(meetings, start, i);
                f += start + premax[j + 1];
            }
            ans = Math.max(ans, f);
            premax[i + 1] = Math.max(premax[i], f - end);
        }
        return ans;
    }

    private int search(int[][] meetings, int target, int right) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (meetings[mid][1] <= target)
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}
