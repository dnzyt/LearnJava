package medium;

// 1029. Two City Scheduling

import java.util.Arrays;

public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[] diff = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
            diff[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(diff);
        for (int i = n - 1; i >= n / 2; i--)
            ans -= diff[i];
        return ans;
    }
}
