package medium;

// 4012. Count of Unfinished Tasks After Each Shift

import java.util.Arrays;

public class Solution4012 {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] presum = new long[n];
        presum[0] = tasks[0];
        for (int i = 1; i < n; i++)
            presum[i] = tasks[i] + presum[i - 1];
        long t = 0;
        int[] ans = new int[shifts.length];
        for (int i = 0; i < shifts.length; i++) {
            t += shifts[i];
            if (t >= presum[n - 1]) {
                ans[i] = 0;
                t = 0;
            } else {
                int j = Arrays.binarySearch(presum, t + 1);
                if (j < 0) j = ~j;
                ans[i] = n - j;
            }
        }
        return ans;
    }
}
