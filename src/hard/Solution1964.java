package hard;

// 1964. Find the Longest Valid Obstacle Course at Each Position

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1964 {
    // O(n*n) TLE
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i, obstacles, memo);
        }
        return ans;
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i == 0) return 1;
        if (memo[i] != -1) return memo[i];
        int ans = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] <= nums[i]) {
                ans = Math.max(ans, dfs(j, nums, memo));
            }
        }
        memo[i] = ans + 1;
        return memo[i];
    }

    public int[] longestObstacleCourseAtEachPosition2(int[] obstacles) {
        int n = obstacles.length;
        List<Integer> g = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = upperBound(g, obstacles[i]);
            if (idx == g.size())
                g.add(obstacles[i]);
            else
                g.set(idx, obstacles[i]);
            ans[i] = idx + 1;
        }
        return ans;
    }

    private int upperBound(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
