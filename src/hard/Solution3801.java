package hard;

// 3801. Minimum Cost to Merge Sorted Lists

public class Solution3801 {
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int u = 1 << n;
        int[][] sorted = new int[u][];
        for (int i = 0; i < n; i++) {
            int highBit = 1 << i;
            for (int s = 0; s < highBit; s++)
                sorted[highBit | s] = merge(sorted[s], lists[i]);
        }

        long[] f = new long[u];
        for (int i = 0; i < u; i++) {
            if ((i & (i - 1)) == 0) // 必须有两个或者两个以上元素才能merge
                continue;
            f[i] = Long.MAX_VALUE;
            // 遍历i的所有非空子集
            for (int sub = (i - 1) & i; sub > (i ^ sub); sub = (sub - 1) & i) {
                int comp = i ^ sub; // 补集
                int lenA = sorted[sub].length;
                int lenB = sorted[comp].length;
                int medA = sorted[sub][(lenA - 1) / 2];
                int medB = sorted[comp][(lenB - 1) / 2];
                f[i] = Math.min(f[i], f[sub] + f[comp] + lenA + lenB + Math.abs(medA - medB));
            }
        }
        return f[u - 1];
    }

    private int[] merge(int[] a, int[] b) {
        if (a == null)
            return b;
        int m = a.length, n = b.length;
        int[] ans = new int[m + n];
        int idx = 0;
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (j == n || i < m && a[i] < b[j])
                ans[idx++] = a[i++];
            else
                ans[idx++] = b[j++];
        }
        return ans;
    }
}
