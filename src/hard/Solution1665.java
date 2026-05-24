package hard;

// 1665. Minimum Initial Energy to Finish Tasks

import java.util.Arrays;

public class Solution1665 {
    // 贪心，(minimum-actual)是这个任务对后面任务的助力，把助力多的任务先做
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int ans = 0;
        int remain = 0;
        for (int i = tasks.length - 1; i >= 0; i--) {
            int[] t = tasks[i];
            ans += Math.max(Math.max(t[0], t[1]) - remain, 0);
            remain = Math.max(remain, Math.max(t[0], t[1])) - t[0];
        }
        return ans;
    }
}
