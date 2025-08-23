package medium;

// 1039. Minimum Score Triangulation of Polygon

import java.util.Arrays;

public class Solution1039 {
    // 区间dp，枚举中间点
    private int[][] memo;
    private int[] nums;
    public int minScoreTriangulation(int[] values) {
        this.nums = values;
        int n = values.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        return partition(0, n - 1);
    }

    private int partition(int l, int r) {
        if (memo[l][r] != -1)
            return memo[l][r];
        int ans = Integer.MAX_VALUE;
        if (l == r || r - l == 1)
            ans = 0;
        else {
            for (int i = l + 1; i < r; i++)
                ans = Math.min(ans, partition(l, i) + partition(i, r) + nums[l] * nums[r] * nums[i]);
        }
        memo[l][r] = ans;
        return ans;
    }
}
