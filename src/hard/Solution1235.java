package hard;

// 1235. Maximum Profit in Job Scheduling

import java.util.Arrays;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        int[] f = new int[n + 1];

        for (int i = 0; i < n; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            int j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    private int search(int[][] jobs, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (jobs[mid][1] <= target)
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}
