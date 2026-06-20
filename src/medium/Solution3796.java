package medium;

// 3796. Find Maximum Value in a Constrained Sequence

import java.util.Arrays;

public class Solution3796 {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] maxVal = new int[n];
        Arrays.fill(maxVal, Integer.MAX_VALUE / 2);
        for (int[] r : restrictions) {
            int idx = r[0], v = r[1];
            maxVal[idx] = v;
        }

        int[] a = new int[n];
        for (int i = 0; i < n - 1; i++)
            a[i + 1] = Math.min(maxVal[i + 1], a[i] + diff[i]);
        for (int i = n - 1; i > 0; i--)
            a[i - 1] = Math.min(a[i - 1], a[i] + diff[i - 1]);
        int ans = 0;
        for (int num : a)
            ans = Math.max(ans, num);
        return ans;
    }
}
