package hard;

// 3534. Path Existence Queries in a Graph II

import java.util.Arrays;
import java.util.Comparator;

public class Solution3534 {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, Comparator.comparingInt(i -> nums[i]));
        int[] rank = new int[n];
        for (int i = 0; i < n; i++)
            rank[idx[i]] = i;

        int w = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stJump = new int[n][w];
        int left = 0;
        for (int j = 0; j < n; j++) {
            while (nums[idx[j]] - nums[idx[left]] > maxDiff)
                left++;
            stJump[j][0] = left;
        }

        for (int k = 1; k < w; k++) {
            for (int j = 0; j < n; j++) {
                int pa = stJump[j][k - 1];
                stJump[j][k] = stJump[pa][k - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == r)
                continue;
            int u = rank[l], v = rank[r];
            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }
            int res = 0;
            for (int k = w - 1; k >= 0; k--) {
                if (stJump[v][k] > u) {
                    v = stJump[v][k];
                    res |= (1 << k);
                }
            }
            ans[i] = stJump[v][0] > u ? -1 : res + 1;

        }
        return ans;
    }
}
